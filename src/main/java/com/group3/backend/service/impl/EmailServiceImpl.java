package com.group3.backend.service.impl;

import com.group3.backend.datasource.entity.CareHomeEntity;
import com.group3.backend.datasource.entity.AlertEntity;
import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.datasource.entity.ResidentEntity;
import com.group3.backend.datasource.repos.AlertRepository;
import com.group3.backend.datasource.repos.CareHomeRepository;
import com.group3.backend.datasource.repos.EmailRepository;
//import com.group3.backend.datasource.repos.MedicationForResidentRepository;
import com.group3.backend.service.EmailService;
import com.group3.backend.service.MedicationCountService;
import com.group3.backend.service.helper.DateHelper;
import com.group3.backend.service.helper.EmailMedicationReadyTemplate;
import com.group3.backend.service.helper.EmailRequestTemplate;
import com.group3.backend.service.helper.EmailStatus;
import com.group3.backend.ui.model.request.EmailRequest;
import com.group3.backend.ui.model.response.EmailContentResponse;
import com.group3.backend.ui.model.response.EmailResponse;
import com.group3.backend.ui.model.response.ErrorMessages;
import com.group3.backend.ui.model.response.EmailStatusResponse;
import com.group3.backend.ui.model.request.MedicationOrderStatusRequest;
//import com.group3.backend.ui.model.request.NewEmailRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
<<<<<<< HEAD
//import java.util.Calendar;
=======
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
>>>>>>> Workingbranch
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    

    @Autowired private MedicationCountService medicationCountService;
    
    @Autowired private MedicationForResidentRepository medForResRepository;
    @Autowired private AlertRepository alertRepository;
    @Autowired private CareHomeRepository careHomeRepository;
    
    //Warning. Could be slow? May need to change to include EAGER fetching, or instead create a custom query.
    //triple for loop is probably very bad. let's see how it does and refactor later.
    public ArrayList<EmailResponse> getAllEmailsForCareHome(long careHomeId) {
    	Optional<CareHomeEntity> resp = careHomeRepository.findById(careHomeId);
    	if (resp.isEmpty()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
    	} else {
    		CareHomeEntity careHome = resp.get();
    		ArrayList<EmailEntity> allEmails= new ArrayList<>();
    		ArrayList<ResidentEntity> allResidents = new ArrayList<>(careHome.getResidents());
    		
    		for (ResidentEntity res: allResidents) {
    			List<MedicationForResidentEntity> allMedsForRes = res.getAllMedicationsForResident();
    			for (MedicationForResidentEntity medForRes: allMedsForRes) {
    				List<AlertEntity> alertsForRes = medForRes.getAlertsForMedication();
    				for (AlertEntity alert: alertsForRes) {
    					if (alert.getEmail() != null) {
    						allEmails.add(alert.getEmail());
    					}
    				}
    			}
    		}
    		
        	ArrayList<EmailResponse> toReturn = new ArrayList<>();
        	for (EmailEntity eEntity: allEmails) {
        		EmailResponse eResponse = new EmailResponse();
        		BeanUtils.copyProperties(eEntity, eResponse);
        		toReturn.add(eResponse);
        	}
        	return toReturn;
    	}
    }
    
    public EmailResponse acceptMedicationRequest(MedicationOrderStatusRequest medOrderStatusRequest) {
    	EmailEntity emailEntity = emailRepository.findByNonGuessableId(medOrderStatusRequest.getRequestId());
    	if (emailEntity == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());}
    	else {
			emailEntity.setStatus(EmailStatus.PROCESSING.getMessage());
		    Date readyDate;
			try {
				readyDate = new SimpleDateFormat("yyyy-MM-dd").parse(medOrderStatusRequest.getReadyDate());
				emailEntity.setDatePharmacySaysReady(readyDate);
			} catch (ParseException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.BAD_DATE_FORMAT.getErrorMessage());
			}  
			emailEntity.setRequestLastUpdatedByPharmacy(new Date());
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
    		emailEntity.setStatus(EmailStatus.INQUIRY.getMessage());
    		emailEntity.setRequestLastUpdatedByPharmacy(new Date());
    		emailEntity.setPharmacyInquiryComment(medOrderStatusRequest.getComment());
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
	          //  mailSender.send(mimeMessageHelper.getMimeMessage());
	            return true;
		 } catch (Exception e) {
			 return false;
		 }
	}
	
	public boolean sendMedicationRequestEmail(EmailRequest emailRequest, String nonGuessableId) {
		String emailToSend = emailRequestTemplate.getSubstitutedTemplate(emailRequest, nonGuessableId);
        String subject = "New medication request from " + emailRequest.getCareHomeName();
        String careHomeEmail = emailRequest.getCareHomeEmail();
        String pharmacyEmail = emailRequest.getPharmacyEmail();
        return sendEmail(emailToSend, subject, careHomeEmail, pharmacyEmail);
	}

	public EmailResponse saveMedicationRequestEmail(long alertId) {
        //If we don't have an alert Id we can't get the info to send the email.
		Optional<AlertEntity> record = alertRepository.findById(alertId);
		if (record.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
		} else {
			AlertEntity alertEntity = record.get();
			if (alertEntity.getEmail() != null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.ALERT_HAS_EMAIL.getErrorMessage());
			}
			
			//now we have no email sent and can go ahead and send this new email.
			String nonGuessableId = generateRandomString();
			String careHomeName = alertEntity.getMedForResident().getResident().getCareHome().getName();
			String subject = "New medication request from " + careHomeName;
			String careHomeEmail = alertEntity.getMedForResident().getResident().getCareHome().getEmail();
			String pharmacyEmail = alertEntity.getMedForResident().getPharmacy().getEmail();
			String medicationName = alertEntity.getMedForResident().getMedication().getName();
			String residentName = alertEntity.getMedForResident().getResident().getFullName();
			EmailRequest emailRequest= new EmailRequest(careHomeEmail, careHomeName, pharmacyEmail, medicationName, residentName);
			
			//for the cycle end date, we should get the latest count and use that
			List<MedicationCountEntity> counts = alertEntity.getMedForResident().getMedicationCounts();
			MedicationCountEntity mostRecentCount = medicationCountService.getMostRecentCount(counts);
			emailRequest.setCycleEndDate(mostRecentCount.getCyclePredictedToEndOn());

			
			String emailToSend = emailRequestTemplate.getSubstitutedTemplate(emailRequest, nonGuessableId);			
	        boolean hasSent = sendEmail(emailToSend, subject, careHomeEmail, pharmacyEmail);
	        
	        if (hasSent) {
	        	EmailEntity emailEntity = new EmailEntity();
	            emailEntity.setNonGuessableId(nonGuessableId);
	            emailEntity.setLastEmailSentDate(new Date());
	            emailEntity.setDateRequested(new Date());
	            emailEntity.setStatus(EmailStatus.SENT_INITIAL_EMAIL.getMessage());
	            emailEntity.setAlertCreatedFrom(alertEntity);
	            emailEntity.setPharmacySentTo(alertEntity.getMedForResident().getPharmacy()); //we include pharmacy here as well so if the default pharmacy for a residents meds changes we still know who this was sent to
	            
	            EmailEntity savedEmail = emailRepository.save(emailEntity);
	            EmailResponse toReturn = new EmailResponse();
	            BeanUtils.copyProperties(savedEmail, toReturn);
	            return toReturn;
	        } else {
	        	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.UNABLE_TO_SEND_EMAIL.getErrorMessage());
	        }
		}
    }


	public ArrayList<EmailResponse> sendAskIfReadyEmails(int daysAhead) {
		Date beforeDate = DateHelper.getStartOfDayXDaysInAdvance(daysAhead+1);
		
		ArrayList<EmailResponse> allSentMails = new ArrayList<>();
		
		ArrayList<EmailEntity> medicationsReadyBeforeDay = emailRepository.findAllReadyBy(beforeDate);
		for (EmailEntity medEmail: medicationsReadyBeforeDay) {
	        String emailToSend = emailMedicationReadyTemplate.getSubstitutedTemplate(medEmail);
	        String subject = "Is " + medEmail.getAlertCreatedFrom().getMedForResident().getMedication() + " ready to collect?";
	        String careHomeEmail = medEmail.getAlertCreatedFrom().getMedForResident().getResident().getCareHome().getEmail();
	        String pharmacyEmail = medEmail.getPharmacy().getEmail();
	        boolean hasSent = sendEmail(emailToSend, subject, careHomeEmail, pharmacyEmail);
	        
	        if (hasSent) {
	        	medEmail.setStatus(EmailStatus.ASKED_IF_READY.getMessage());
	        	medEmail.setLastEmailSentDate(new Date());
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

	@Override
	public EmailResponse medicationIsReady(MedicationOrderStatusRequest medOrderStatusRequest) {
		EmailEntity emailEntity = emailRepository.findByNonGuessableId(medOrderStatusRequest.getRequestId());
    	if (emailEntity == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());}
    	else {
			emailEntity.setStatus(EmailStatus.READY.getMessage());
			emailEntity.setRequestLastUpdatedByPharmacy(new Date());
			emailRepository.save(emailEntity);
			EmailResponse toReturn = new EmailResponse();
			BeanUtils.copyProperties(emailEntity, toReturn);
			return toReturn;
    	}
	}

	@Override
	public EmailResponse tryResendEmail(String nonGuessableId) {
		EmailEntity emailEntity = emailRepository.findByNonGuessableId(nonGuessableId);
		if (canResendEmail(emailEntity)) {
			AlertEntity alertEntity = emailEntity.getAlertCreatedFrom();
			String careHomeName = alertEntity.getMedForResident().getResident().getCareHome().getName();
			String careHomeEmail = alertEntity.getMedForResident().getResident().getCareHome().getEmail();
			String pharmacyEmail = alertEntity.getMedForResident().getPharmacy().getEmail();
			String medicationName = alertEntity.getMedForResident().getMedication().getName();
			String residentName = alertEntity.getMedForResident().getResident().getFullName();
			EmailRequest emailRequest= new EmailRequest(careHomeEmail, careHomeName, pharmacyEmail, medicationName, residentName);
			
			//for the cycle end date, we should get the latest count and use that
			List<MedicationCountEntity> counts = alertEntity.getMedForResident().getMedicationCounts();
			counts.sort((thisObj, that) -> {
				return that.getCountDoneOnDate().compareTo(thisObj.getCountDoneOnDate());
			});;
			emailRequest.setCycleEndDate(counts.get(0).getCyclePredictedToEndOn());
			
			boolean hasSent = sendMedicationRequestEmail(emailRequest, emailEntity.getNonGuessableId());
			
			if (hasSent) {
				emailEntity.setLastEmailSentDate(new Date());
				EmailEntity savedEmail = emailRepository.save(emailEntity);
				EmailResponse emailResponse = new EmailResponse();
				BeanUtils.copyProperties(savedEmail, emailResponse);
				return emailResponse;
			} else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.UNABLE_TO_SEND_EMAIL.getErrorMessage());
			}
		}
		return null;
	}
	
	//brought out into it's own method so can be tested if necessary.
	boolean canResendEmail(EmailEntity emailEntity) {
		if (emailEntity == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());}
		//only allow to resend email when the status is sent initial email
		//if we've asked if ready and not received a response the email should auto re-send.
		if (!emailEntity.getStatus().equals(EmailStatus.SENT_INITIAL_EMAIL.getMessage())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.NOT_RIGHT_STEP.getErrorMessage());
		}
		//email has to be sent yesterday or earlier to resend
		Date zeroHourThisMorning = DateHelper.getStartOfDayXDaysInAdvance(0);
		if (emailEntity.getLastEmailSentDate().before(zeroHourThisMorning)) {
			return true;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.SENDING_TOO_SOON.getErrorMessage());
		}
	}

	@Override
	public EmailContentResponse getLastEmailContent(String nonGuessableId) {
		//first we need to get which email template to use.
		EmailEntity emailEntity = emailRepository.findByNonGuessableId(nonGuessableId);
		if (emailEntity == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());}
		
		EmailContentResponse toReturn = new EmailContentResponse();
		toReturn.setNonGuessableId(emailEntity.getNonGuessableId());
		
		AlertEntity alertEntity = emailEntity.getAlertCreatedFrom();
		String careHomeName = alertEntity.getMedForResident().getResident().getCareHome().getName();
		String careHomeEmail = alertEntity.getMedForResident().getResident().getCareHome().getEmail();
		String pharmacyEmail = alertEntity.getMedForResident().getPharmacy().getEmail();
		String medicationName = alertEntity.getMedForResident().getMedication().getName();
		String residentName = alertEntity.getMedForResident().getResident().getFullName();
		EmailRequest emailRequest= new EmailRequest(careHomeEmail, careHomeName, pharmacyEmail, medicationName, residentName);
		
		//for the cycle end date, we should get the latest count and use that
		List<MedicationCountEntity> counts = alertEntity.getMedForResident().getMedicationCounts();
		counts.sort((thisObj, that) -> {
			return that.getCountDoneOnDate().compareTo(thisObj.getCountDoneOnDate());
		});;
		emailRequest.setCycleEndDate(counts.get(0).getCyclePredictedToEndOn());
		
		BeanUtils.copyProperties(emailEntity, emailRequest);
		
		//show initial email if sent initial email, inquiry, or processing
		if (emailEntity.getStatus().equals(EmailStatus.SENT_INITIAL_EMAIL.getMessage()) ||
				emailEntity.getStatus().equals(EmailStatus.PROCESSING.getMessage()) ||
				emailEntity.getStatus().equals(EmailStatus.INQUIRY.getMessage())) {
			
			toReturn.setEmailHtml(emailRequestTemplate.getSubstitutedTemplate(emailRequest, emailEntity.getNonGuessableId(), false));
		} else {
			toReturn.setEmailHtml(emailMedicationReadyTemplate.getSubstitutedTemplate(emailEntity, false));
		}
		return toReturn;
	}

	@Override
	public EmailResponse markCollected(String id) {
		EmailEntity emailEntity = emailRepository.findByNonGuessableId(id);
		if (emailEntity == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());}
		if (!emailEntity.getStatus().equals(EmailStatus.READY.getMessage())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.NOT_RIGHT_STEP.getErrorMessage());
		}
		
		emailEntity.setStatus(EmailStatus.COMPLETED.getMessage());
		EmailEntity savedEmailEntity = emailRepository.save(emailEntity);
		
		EmailResponse emailResponse = new EmailResponse();
		BeanUtils.copyProperties(savedEmailEntity, emailResponse);
		return emailResponse;
	}

	@Override
	public EmailResponse undoMarkCollected(String id) {
		EmailEntity emailEntity = emailRepository.findByNonGuessableId(id);
		if (emailEntity == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());}
		if (!emailEntity.getStatus().equals(EmailStatus.COMPLETED.getMessage())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.NOT_RIGHT_STEP.getErrorMessage());
		}
		
		emailEntity.setStatus(EmailStatus.READY.getMessage());
		EmailEntity savedEmailEntity = emailRepository.save(emailEntity);
		
		EmailResponse emailResponse = new EmailResponse();
		BeanUtils.copyProperties(savedEmailEntity, emailResponse);
		return emailResponse;
	}
}







