package com.group3.backend.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group3.backend.datasource.entity.AlertEntity;
import com.group3.backend.datasource.entity.AutomaticEmailEntity;
import com.group3.backend.datasource.entity.CareHomeEntity;
import com.group3.backend.datasource.repos.AlertRepository;
import com.group3.backend.datasource.repos.AutomaticEmailRepository;
import com.group3.backend.datasource.repos.CareHomeRepository;
import com.group3.backend.service.AutomaticEmailService;
import com.group3.backend.service.EmailService;
import com.group3.backend.ui.model.request.AutomaticEmailRequest;
import com.group3.backend.ui.model.response.AutomaticEmailResponse;
import com.group3.backend.ui.model.response.EmailResponse;
import com.group3.backend.ui.model.response.ErrorMessages;

@Service
public class AutomaticEmailServiceImpl implements AutomaticEmailService {
	
	@Autowired
    private CareHomeRepository careHomeRepository;
	
	@Autowired
    private AlertRepository alertRepository;
	
	@Autowired private EmailService emailService;
	
	public AutomaticEmailResponse updateAutomaticEmail(AutomaticEmailRequest autoEmailRequest) {
		Optional<CareHomeEntity> res = careHomeRepository.findById(autoEmailRequest.getCareHomeId());
		if (res.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
		} else {
			CareHomeEntity careHome = res.get();
			careHome.setUsesAutoEmail(autoEmailRequest.isUsesAutomaticEmails());
			CareHomeEntity savedEntity = careHomeRepository.save(careHome);
			AutomaticEmailResponse autoEmailResp = new AutomaticEmailResponse();
			autoEmailResp.setCareHomeId(savedEntity.getCareHomeId());
			autoEmailResp.setUsesAutomaticEmails(savedEntity.isUsesAutoEmail());
			return autoEmailResp;
		}
	}
	
	public AutomaticEmailResponse getUsesAutomaticEmail(long careHomeId) {
		Optional<CareHomeEntity> res = careHomeRepository.findById(careHomeId);
		if (res.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
		} else {
			CareHomeEntity careHome = res.get();
			AutomaticEmailResponse autoEmailResp = new AutomaticEmailResponse();
			autoEmailResp.setCareHomeId(careHome.getCareHomeId());
			autoEmailResp.setUsesAutomaticEmails(careHome.isUsesAutoEmail());
			return autoEmailResp;
		}
	}


	//TODO: waiting on alerts work to be completed
	public ArrayList<EmailResponse> sendEmailsForAllNewAlerts() {
		ArrayList<EmailResponse> emailsSent = new ArrayList<>();
		
		ArrayList<AlertEntity> allAlerts = alertRepository.findAll();
		for (AlertEntity alert: allAlerts) {
			if (alert.getEmail() == null) {
				//then there's no email that's been sent for this alert.
				try {
					EmailResponse emailResp = emailService.saveMedicationRequestEmail(alert.getId());
					emailsSent.add(emailResp);
				} catch (Exception e) {
					EmailResponse badEmail = new EmailResponse();
					badEmail.setStatus("Failed for alert Id: " + alert.getId());
					emailsSent.add(badEmail);
				}
			}
		}
		return emailsSent;
	}
	
	

}
