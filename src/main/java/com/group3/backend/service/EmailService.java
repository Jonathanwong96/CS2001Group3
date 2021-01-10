package com.group3.backend.service;

import java.util.ArrayList;

import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.ui.model.request.EmailRequest;
import com.group3.backend.ui.model.request.MedicationOrderStatusRequest;
import com.group3.backend.ui.model.response.EmailResponse;
import com.group3.backend.ui.model.response.EmailStatusResponse;

public interface EmailService {
    boolean sendEmail(String emailToSend, String subject, String careHomeEmail, String pharmacyEmail);
    EmailResponse sendMedicationRequestEmail(EmailRequest emailRequest);
    ArrayList<EmailResponse> sendAskIfReadyEmails(int daysInAdvance);
    EmailResponse acceptMedicationRequest(MedicationOrderStatusRequest medOrderStatusRequest);
    EmailResponse rejectMedicationRequest(MedicationOrderStatusRequest medOrderStatusRequest);
    ArrayList<EmailResponse> getAllEmailsForCareHome(String careHomeName);
    EmailStatusResponse getMedicationRequestDetails(String nonGuessableId);
}
