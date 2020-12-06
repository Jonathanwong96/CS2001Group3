package com.group3.backend.service;

import java.util.ArrayList;

import com.group3.backend.ui.model.request.EmailRequest;
import com.group3.backend.ui.model.response.EmailResponse;

public interface EmailService {
    EmailResponse sendEmail(EmailRequest emailRequest);
    EmailResponse acceptMedicationRequest(String id);
    EmailResponse rejectMedicationRequest(String id);
    ArrayList<EmailResponse> getAllEmailsForCareHome(String careHomeName);
}
