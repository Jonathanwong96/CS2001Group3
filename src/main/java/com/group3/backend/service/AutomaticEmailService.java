package com.group3.backend.service;

import com.group3.backend.ui.model.response.AutomaticEmailResponse;
import com.group3.backend.ui.model.response.EmailResponse;

import java.util.ArrayList;

import com.group3.backend.ui.model.request.AutomaticEmailRequest;

public interface AutomaticEmailService {
	AutomaticEmailResponse updateAutomaticEmail(AutomaticEmailRequest autoEmailRequest);
	AutomaticEmailResponse getUsesAutomaticEmail(long careHomeId);
	ArrayList<EmailResponse> sendEmailsForAllNewAlerts();
}
