package com.group3.backend.service.impl;

import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.datasource.repos.EmailRepository;
import com.group3.backend.service.EmailService;
import com.group3.backend.service.helper.DateHelper;
import com.group3.backend.service.helper.EmailMedicationReadyTemplate;
import com.group3.backend.service.helper.EmailRequestTemplate;
import com.group3.backend.ui.model.request.EmailRequest;
import com.group3.backend.ui.model.response.EmailResponse;
import com.group3.backend.ui.model.response.ErrorMessages;
import com.group3.backend.ui.model.response.EmailStatusResponse;
import com.group3.backend.ui.model.request.MedicationOrderStatusRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private EmailRequestTemplate emailRequestTemplate;
    
    @Autowired
    private EmailMedicationReadyTemplate emailMedicationReadyTemplate;
    
    @Autowired
    private EmailRepository emailRepository;
    
    public ArrayList<EmailResponse> getAllEmailsForCareHome(String careHomeName) {
    	ArrayList<EmailEntity> allEmails = emailRepository.findAllByCareHomeName(careHomeName);
    	ArrayList<EmailResponse> toReturn = new ArrayList<>();
    	for (EmailEntity eEntity: allEmails) {
    		EmailResponse eResponse = new EmailResponse();
    		BeanUtils.copyProperties(eEntity, eResponse);
    		toReturn.add(eResponse);
    	}
    	return toReturn;
    }
    
    public EmailResponse acceptMedicationRequest(MedicationOrderStatusRequest medOrderStatusRequest) {
    	EmailEntity emailEntity = emailRepository.findByNonGuessableId(medOrderStatusRequest.getRequestId());
    	if (emailEntity == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());}
    	else {
			emailEntity.setStatus("accepted");
		    Date readyDate;
			try {
				readyDate = new SimpleDateFormat("yyyy-MM-dd").parse(medOrderStatusRequest.getReadyDate());
				emailEntity.setDateMedicationToBeReady(readyDate);
			} catch (ParseException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.BAD_DATE_FORMAT.getErrorMessage());
			}  
			emailEntity.setDateUpdatedByPharmacy(new Date());
			emailRepository.save(emailEntity);
			EmailResponse toReturn = new EmailResponse();
			BeanUtils.copyProperties(emailEntity, toReturn);
			return toReturn;
    	}
    }
    
    public EmailResponse rejectMedicationRequest(MedicationOrderStatusRequest medOrderStatusRequest) {
    	EmailEntity emailEntity = emailRepository.findByNonGuessableId(medOrderStatusRequest.getRequestId());
    	if (emailEntity == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());}
    	else {
    		emailEntity.setStatus("rejected");
    		emailEntity.setDateUpdatedByPharmacy(new Date());
    		emailEntity.setPharmacyComment(medOrderStatusRequest.getComment());
    		emailRepository.save(emailEntity);
    		EmailResponse toReturn = new EmailResponse();
    		BeanUtils.copyProperties(emailEntity, toReturn);
    		return toReturn;
    	}
    }

	public EmailStatusResponse getMedicationRequestDetails(String nonGuessableId) {
		EmailEntity emailEntity = emailRepository.findByNonGuessableId(nonGuessableId);
		if (emailEntity == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());}
    	else {
    		EmailStatusResponse medResponse = new EmailStatusResponse();
    		BeanUtils.copyProperties(emailEntity, medResponse);
    		return medResponse;
    	}
	}
	
	public boolean sendEmail(String emailToSend, String subject, String careHomeEmail, String pharmacyEmail) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		 try {
	        	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	            mimeMessageHelper.setSubject(subject);
	            mimeMessageHelper.setFrom("carehomehelper@gmail.com");
	            mimeMessageHelper.setReplyTo(careHomeEmail);
	            mimeMessageHelper.setTo(pharmacyEmail);
	            mimeMessageHelper.setText(emailToSend, true); //true here to indicate sending html message
//	            mailSender.send(mimeMessageHelper.getMimeMessage());
	            return true;
		 } catch (Exception e) {
			 return false;
		 }
	}

	public EmailResponse sendMedicationRequestEmail(EmailRequest emailRequest) {
        String nonGuessableId = generateRandomString();
        String emailToSend = emailRequestTemplate.getSubstitutedTemplate(emailRequest, nonGuessableId);
        String subject = "New medication request from " + emailRequest.getCareHomeName();
        String careHomeEmail = emailRequest.getUsersEmail();
        String pharmacyEmail = emailRequest.getPharmacyEmail();
        boolean hasSent = sendEmail(emailToSend, subject, careHomeEmail, pharmacyEmail);
        
        if (hasSent) {
        	EmailEntity emailEntity = new EmailEntity();
            BeanUtils.copyProperties(emailRequest, emailEntity);
            emailEntity.setNonGuessableId(nonGuessableId);
            emailEntity.setDateSent(new Date());
            emailEntity.setReplyToAddr(emailRequest.getUsersEmail());
            
            EmailEntity savedEmail = emailRepository.save(emailEntity);
            EmailResponse toReturn = new EmailResponse();
            BeanUtils.copyProperties(savedEmail, toReturn);
            return toReturn;
        } else {
        	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.UNABLE_TO_SEND_EMAIL.getErrorMessage());
        }
    }


	public ArrayList<EmailResponse> sendAskIfReadyEmails(int daysAhead) {
		Date beforeDate = DateHelper.getMidnightXDaysInAdvance(daysAhead+1);
		
		ArrayList<EmailResponse> allSentMails = new ArrayList<>();
		
		ArrayList<EmailEntity> medicationsReadyBeforeDay = emailRepository.findAllUncollectedBy(beforeDate);
		for (EmailEntity medEmail: medicationsReadyBeforeDay) {
			//TODO: change this to be the EmailMedicationReadyTemplate
			//TODO: refactor sendEmail func to just take in a MIME message.
	        String emailToSend = emailMedicationReadyTemplate.getSubstitutedTemplate(medEmail);
	        String subject = "Is " + medEmail.getMedicationName() + " ready to collect?";
	        String careHomeEmail = medEmail.getCareHomeEmail();
	        String pharmacyEmail = medEmail.getPharmacyEmail();
	        boolean hasSent = sendEmail(emailToSend, subject, careHomeEmail, pharmacyEmail);
	        
	        if (hasSent) {
	        	medEmail.setStatus("Asked if medication is ready to collect");
	        	emailRepository.save(medEmail); //inefficient to save while in a loop. can later refactor out using saveAll() method if needed
	        	EmailResponse emailResp = new EmailResponse();
				BeanUtils.copyProperties(medEmail, emailResp);
				allSentMails.add(emailResp);
	        }
		}
		return allSentMails;
	}
	
	    
    //62 different options for 20 chars. probability of guessing a route is (1 / (20^62)) - small enough to be negligible.
    private String generateRandomString() {
    	String validChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	String toReturn = "";
    	while (toReturn.length() <= 20) {
    		int randIndex = (int) Math.floor(Math.random() * validChars.length());
    		toReturn += validChars.charAt(randIndex);
    	}
    	return toReturn;
    }
}







