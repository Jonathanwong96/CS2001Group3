package com.group3.backend.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group3.backend.datasource.entity.AutomaticEmailEntity;
import com.group3.backend.datasource.repos.AutomaticEmailRepository;
import com.group3.backend.service.AutomaticEmailService;
import com.group3.backend.ui.model.request.AutomaticEmailRequest;
import com.group3.backend.ui.model.response.AutomaticEmailResponse;
import com.group3.backend.ui.model.response.EmailResponse;
import com.group3.backend.ui.model.response.ErrorMessages;

@Service
public class AutomaticEmailServiceImpl implements AutomaticEmailService {

	@Autowired
    private AutomaticEmailRepository automaticEmailRepository;
	
	public AutomaticEmailResponse updateAutomaticEmail(AutomaticEmailRequest autoEmailRequest) {
		AutomaticEmailEntity autoEmailEntity = automaticEmailRepository.findByCareHomeId(autoEmailRequest.getCareHomeId());
		if (autoEmailEntity != null) {
			autoEmailEntity.setUsesAutomaticEmails(autoEmailRequest.isUsesAutomaticEmails());
			AutomaticEmailEntity saved = automaticEmailRepository.save(autoEmailEntity);
			AutomaticEmailResponse toReturn = new AutomaticEmailResponse();
			BeanUtils.copyProperties(saved, toReturn);
			return toReturn;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
		}
	}


	public AutomaticEmailResponse createAutomaticEmail(AutomaticEmailRequest autoEmailRequest) {
		AutomaticEmailEntity autoEmailEntity = new AutomaticEmailEntity();
		BeanUtils.copyProperties(autoEmailRequest, autoEmailEntity);
		AutomaticEmailEntity saved = automaticEmailRepository.save(autoEmailEntity);
		AutomaticEmailResponse toReturn = new AutomaticEmailResponse();
		BeanUtils.copyProperties(saved, toReturn);
		return toReturn;
	}
	
	public AutomaticEmailResponse getUsesAutomaticEmail(long careHomeId) {
		AutomaticEmailEntity autoEmailEntity = automaticEmailRepository.findByCareHomeId(careHomeId);
		if (autoEmailEntity != null) {
			AutomaticEmailResponse toReturn = new AutomaticEmailResponse();
			BeanUtils.copyProperties(autoEmailEntity, toReturn);
			return toReturn;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
		}
	}


	//TODO: waiting on alerts work to be completed
	public ArrayList<EmailResponse> sendEmailsForAllNewAlerts() {
		//first get out all carehomes with auto emails enabled
		ArrayList<AutomaticEmailEntity> careHomes = automaticEmailRepository.findAllByUsesAutomaticEmails(true);
		for (AutomaticEmailEntity careHomeWithAutoEmails: careHomes) {
			long careHomeId = careHomeWithAutoEmails.getCareHomeId();
			//then get out all alerts for that carehome
			//call sendMail function
		}
		return null;
	}
	
	

}
