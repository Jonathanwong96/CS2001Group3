package com.group3.backend.service.impl;

import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.datasource.repos.EmailRepository;
import com.group3.backend.service.EmailService;
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

	public EmailResponse sendEmail(EmailRequest emailRequest) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        
        String nonGuessableId = generateRandomString();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject("New medication request from " + emailRequest.getCareHomeName());
            mimeMessageHelper.setFrom("carehomehelper@gmail.com");
            mimeMessageHelper.setReplyTo(emailRequest.getCareHomeEmail());
            mimeMessageHelper.setTo(emailRequest.getPharmacyEmail());
            mimeMessageHelper.setText(emailRequestTemplate.getSubstitutedTemplate(emailRequest, nonGuessableId), true); //true here to indicate sending html message
//            mailSender.send(mimeMessageHelper.getMimeMessage());
            
            EmailEntity emailEntity = new EmailEntity();
            BeanUtils.copyProperties(emailRequest, emailEntity);
            emailEntity.setNonGuessableId(nonGuessableId);
            emailEntity.setDateSent(new Date());
            emailEntity.setReplyToAddr(emailRequest.getCareHomeEmail());
            
            EmailEntity savedEmail = emailRepository.save(emailEntity);
            EmailResponse toReturn = new EmailResponse();
            BeanUtils.copyProperties(savedEmail, toReturn);
            return toReturn;
            
        } catch (Exception e) {
            e.printStackTrace();
            return new EmailResponse(); //TODO need to throw an error or customise the return type here
        }
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

    //NOTE: function only gets out the emails due on this day. Should be expanded to also get out emails that haven't been responded to.
	public ArrayList<EmailEntity> getMedicationsReadyInXDays(int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, days);
		Date desiredDate = cal.getTime();
		
		ArrayList<EmailEntity> medicationsForCollectionOnDay = emailRepository.findAllByDateMedicationToBeReady(desiredDate);
		for (EmailEntity medEmail: medicationsForCollectionOnDay) {
			EmailRequest emailReq = new EmailRequest();
			BeanUtils.copyProperties(medEmail, emailReq);
			sendEmail(emailReq);
		}
		return medicationsForCollectionOnDay;
	}
}







