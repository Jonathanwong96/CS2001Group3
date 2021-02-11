package com.group3.backend.service;

import java.util.ArrayList;

import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.ui.model.request.EmailRequest;
import com.group3.backend.ui.model.request.MedicationOrderStatusRequest;
import com.group3.backend.ui.model.response.EmailContentResponse;
import com.group3.backend.ui.model.response.EmailResponse;
import com.group3.backend.ui.model.response.EmailStatusResponse;

public interface EmailService {
    boolean sendEmail(String emailToSend, String subject, String careHomeEmail, String pharmacyEmail);
    EmailResponse saveMedicationRequestEmail(long alertId);
    boolean sendMedicationRequestEmail(EmailRequest emailRequest, String nonGuessableId);
    ArrayList<EmailResponse> sendAskIfReadyEmails(int daysInAdvance);
    EmailResponse tryResendEmail(String id);
    EmailResponse acceptMedicationRequest(MedicationOrderStatusRequest medOrderStatusRequest);
    EmailResponse rejectMedicationRequest(MedicationOrderStatusRequest medOrderStatusRequest);
    EmailResponse medicationIsReady(MedicationOrderStatusRequest medOrderStatusRequest);
    ArrayList<EmailResponse> getAllEmailsForCareHome(long careHomeId);
    EmailStatusResponse getMedicationRequestDetails(String nonGuessableId);
    EmailContentResponse getLastEmailContent(String id);
    EmailResponse markCollected(String id);
    EmailResponse undoMarkCollected(String id);
}
