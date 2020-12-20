package com.group3.backend.service;

import java.util.ArrayList;

import com.group3.backend.ui.model.request.EmailRequest;
import com.group3.backend.ui.model.request.MedicationOrderStatusRequest;
import com.group3.backend.ui.model.response.EmailResponse;
import com.group3.backend.ui.model.response.EmailStatusResponse;

public interface EmailService {
    EmailResponse sendEmail(EmailRequest emailRequest);
    EmailResponse acceptMedicationRequest(MedicationOrderStatusRequest medOrderStatusRequest);
    EmailResponse rejectMedicationRequest(MedicationOrderStatusRequest medOrderStatusRequest);
    ArrayList<EmailResponse> getAllEmailsForCareHome(String careHomeName);
    EmailStatusResponse getMedicationRequestDetails(String nonGuessableId);
}
