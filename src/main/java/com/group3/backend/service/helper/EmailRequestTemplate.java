package com.group3.backend.service.helper;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.ui.model.request.EmailRequest;

@Component
public class EmailRequestTemplate {
    @Value("${frontEnd.url}")
    private String frontEndUrl;
	
	private final String template = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" + 
			"<!-- saved from url=(0098)file:///C:/Users/whata/AppData/Local/Temp/Temp1_beefree-k9b5psb3ttg-2.zip/beefree-k9b5psb3ttg.html -->\n" + 
			"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" + 
			"<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" + 
			"\n" + 
			"<meta content=\"width=device-width\" name=\"viewport\">\n" + 
			"<!--[if !mso]><!-->\n" + 
			"<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\">\n" + 
			"<!--<![endif]-->\n" + 
			"<title></title>\n" + 
			"<!--[if !mso]><!-->\n" + 
			"<!--<![endif]-->\n" + 
			"<style type=\"text/css\">\n" + 
			"		body {\n" + 
			"			margin: 0;\n" + 
			"			padding: 0;\n" + 
			"		}\n" + 
			"\n" + 
			"		table,\n" + 
			"		td,\n" + 
			"		tr {\n" + 
			"			vertical-align: top;\n" + 
			"			border-collapse: collapse;\n" + 
			"		}\n" + 
			"\n" + 
			"		* {\n" + 
			"			line-height: inherit;\n" + 
			"		}\n" + 
			"\n" + 
			"		a[x-apple-data-detectors=true] {\n" + 
			"			color: inherit !important;\n" + 
			"			text-decoration: none !important;\n" + 
			"		}\n" + 
			"	</style>\n" + 
			"<style id=\"media-query\" type=\"text/css\">\n" + 
			"		@media (max-width: 520px) {\n" + 
			"\n" + 
			"			.block-grid,\n" + 
			"			.col {\n" + 
			"				min-width: 320px !important;\n" + 
			"				max-width: 100% !important;\n" + 
			"				display: block !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.block-grid {\n" + 
			"				width: 100% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.col {\n" + 
			"				width: 100% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.col_cont {\n" + 
			"				margin: 0 auto;\n" + 
			"			}\n" + 
			"\n" + 
			"			img.fullwidth,\n" + 
			"			img.fullwidthOnMobile {\n" + 
			"				max-width: 100% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack .col {\n" + 
			"				min-width: 0 !important;\n" + 
			"				display: table-cell !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack.two-up .col {\n" + 
			"				width: 50% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack .col.num2 {\n" + 
			"				width: 16.6% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack .col.num3 {\n" + 
			"				width: 25% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack .col.num4 {\n" + 
			"				width: 33% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack .col.num5 {\n" + 
			"				width: 41.6% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack .col.num6 {\n" + 
			"				width: 50% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack .col.num7 {\n" + 
			"				width: 58.3% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack .col.num8 {\n" + 
			"				width: 66.6% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack .col.num9 {\n" + 
			"				width: 75% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.no-stack .col.num10 {\n" + 
			"				width: 83.3% !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.video-block {\n" + 
			"				max-width: none !important;\n" + 
			"			}\n" + 
			"\n" + 
			"			.mobile_hide {\n" + 
			"				min-height: 0px;\n" + 
			"				max-height: 0px;\n" + 
			"				max-width: 0px;\n" + 
			"				display: none;\n" + 
			"				overflow: hidden;\n" + 
			"				font-size: 0px;\n" + 
			"			}\n" + 
			"\n" + 
			"			.desktop_hide {\n" + 
			"				display: block !important;\n" + 
			"				max-height: none !important;\n" + 
			"			}\n" + 
			"		}\n" + 
			"	</style>\n" + 
			"</head>\n" + 
			"<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #FFFFFF;\">\n" + 
			"<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" + 
			"<table bgcolor=\"#FFFFFF\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF; width: 100%;\" valign=\"top\" width=\"100%\">\n" + 
			"<tbody>\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\n" + 
			"<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" + 
			"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#FFFFFF\"><![endif]-->\n" + 
			"<div style=\"background-color:transparent;\">\n" + 
			"<div class=\"block-grid\" style=\"min-width: 320px; max-width: 500px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #fcfcfc;\">\n" + 
			"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#fcfcfc;\">\n" + 
			"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:500px\"><tr class=\"layout-full-width\" style=\"background-color:#fcfcfc\"><![endif]-->\n" + 
			"<!--[if (mso)|(IE)]><td align=\"center\" width=\"500\" style=\"background-color:#fcfcfc;width:500px; border-top: 2px solid #000000; border-left: 2px solid #000000; border-bottom: 2px solid #000000; border-right: 2px solid #000000;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 25px; padding-left: 25px; padding-top:25px; padding-bottom:50px;\"><![endif]-->\n" + 
			"<div class=\"col num12\" style=\"min-width: 320px; max-width: 500px; display: table-cell; vertical-align: top; width: 496px;\">\n" + 
			"<div class=\"col_cont\" style=\"width:100% !important;\">\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\n" + 
			"<div style=\"border-top:2px solid #000000; border-left:2px solid #000000; border-bottom:2px solid #000000; border-right:2px solid #000000; padding-top:25px; padding-bottom:50px; padding-right: 25px; padding-left: 25px;\">\n" + 
			"<!--<![endif]-->\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Arial, sans-serif\"><![endif]-->\n" + 
			"<div style=\"color:#555555;font-family:Arial, &#39;Helvetica Neue&#39;, Helvetica, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" + 
			"<div style=\"line-height: 1.2; font-size: 12px; color: #555555; font-family: Arial, &#39;Helvetica Neue&#39;, Helvetica, sans-serif; mso-line-height-alt: 14px;\">\n" + 
			"<p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 17px; margin: 0;\">New Medication Request</p>\n" + 
			"</div>\n" + 
			"</div>\n" + 
			"<!--[if mso]></td></tr></table><![endif]-->\n" + 
			"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" + 
			"<tbody>\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\n" + 
			"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" + 
			"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid #BBBBBB; width: 100%;\" valign=\"top\" width=\"100%\">\n" + 
			"<tbody>\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\n" + 
			"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" + 
			"</tr>\n" + 
			"</tbody>\n" + 
			"</table>\n" + 
			"</td>\n" + 
			"</tr>\n" + 
			"</tbody>\n" + 
			"</table>\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Arial, sans-serif\"><![endif]-->\n" + 
			"<div style=\"color:#555555;font-family:Arial, &#39;Helvetica Neue&#39;, Helvetica, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" + 
			"<div style=\"line-height: 1.2; font-size: 12px; color: #555555; font-family: Arial, &#39;Helvetica Neue&#39;, Helvetica, sans-serif; mso-line-height-alt: 14px;white-space: pre-wrap\">Hi there, this is from [users_email] using caringforcarehomes.com\n" + 
			"\n" + 
			"We're running low on [medication] for [resident] and would like to order another cycle. Their current cycle ends on [date]. Please could you click on one of the buttons below to inform the app whether this is possible or not?\n" + 
			"\n" + 
			"Thankyou!\n" + 
			"\n" + 
			"[users_name] from [care_home_name]</div>\n" + 
			"</div>\n" + 
			"<!--[if mso]></td></tr></table><![endif]-->\n" + 
			"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" + 
			"<tbody>\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\n" + 
			"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" + 
			"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid #BBBBBB; width: 100%;\" valign=\"top\" width=\"100%\">\n" + 
			"<tbody>\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\n" + 
			"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" + 
			"</tr>\n" + 
			"</tbody>\n" + 
			"</table>\n" + 
			"</td>\n" + 
			"</tr>\n" + 
			"</tbody>\n" + 
			"</table>\n" + 
			"<div align=\"center\" class=\"button-container\" style=\"padding-top:30px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:28.5pt; width:142.5pt; v-text-anchor:middle;\" arcsize=\"11%\" strokeweight=\"1.5pt\" strokecolor=\"#000000\" fillcolor=\"#008450\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#ffffff; font-family:Arial, sans-serif; font-size:16px\"><![endif]-->\n" + 
			"<a href=\"[href_accept]\" style=\"cursor:pointer;text-decoration:none;display:inline-block;color:#ffffff;background-color:#FAD0C9;border-radius:4px;-webkit-border-radius:4px;-moz-border-radius:4px;width:auto; width:auto;;border-top:2px solid #000000;border-right:2px solid #000000;border-bottom:2px solid #000000;border-left:2px solid #000000;padding-top:5px;padding-bottom:5px;font-family:Arial, &#39;Helvetica Neue&#39;, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"><span style=\"padding-left:20px;padding-right:20px;font-size:16px;display:inline-block;\"><span style=\"font-size: 16px; line-height: 1.5; mso-line-height-alt: 24px;color: #6e6e6d\">Processing Medication</span></span></a>\n" + 
			"<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\n" + 
			"</div>\n" + 
			"<div align=\"center\" class=\"button-container\" style=\"padding-top:10px;padding-right:10px;padding-bottom:30px;padding-left:10px;\">\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:28.5pt; width:179.25pt; v-text-anchor:middle;\" arcsize=\"11%\" strokeweight=\"1.5pt\" strokecolor=\"#000000\" fillcolor=\"#efb700\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#ffffff; font-family:Arial, sans-serif; font-size:16px\"><![endif]-->\n" + 
			"<a href=\"[href_inquiry]\" style=\"cursor:pointer;text-decoration:none;display:inline-block;color:#ffffff;background-color:#6E6E6D;border-radius:4px;-webkit-border-radius:4px;-moz-border-radius:4px;width:auto; width:auto;;border-top:2px solid #000000;border-right:2px solid #000000;border-bottom:2px solid #000000;border-left:2px solid #000000;padding-top:5px;padding-bottom:5px;font-family:Arial, &#39;Helvetica Neue&#39;, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"><span style=\"padding-left:47px;padding-right:47px;font-size:16px;display:inline-block;\"><span style=\"font-size: 16px; line-height: 1.5; word-break: break-word; mso-line-height-alt: 24px;color: #FAD0C9\">Inquiry needed</span></span></a>\n" + 
			"<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\n" + 
			"</div>\n" + 
			"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" + 
			"<tbody>\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\n" + 
			"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" + 
			"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 1px solid #BBBBBB; width: 100%;\" valign=\"top\" width=\"100%\">\n" + 
			"<tbody>\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\n" + 
			"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" + 
			"</tr>\n" + 
			"</tbody>\n" + 
			"</table>\n" + 
			"</td>\n" + 
			"</tr>\n" + 
			"</tbody>\n" + 
			"</table>\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Arial, sans-serif\"><![endif]-->\n" + 
			"<div style=\"color:#555555;font-family:Arial, &#39;Helvetica Neue&#39;, Helvetica, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" + 
			"<div style=\"line-height: 1.2; font-size: 12px; color: #555555; font-family: Arial, &#39;Helvetica Neue&#39;, Helvetica, sans-serif; mso-line-height-alt: 14px;\">\n" + 
			"<p style=\"font-size: 10px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 12px; margin: 0;\"><span style=\"font-size: 10px;\">Caring For Care Homes is a system designed to automate medication requests for when stock is running low, saving time for Care Home Workers.</span></p>\n" + 
			"<p style=\"font-size: 10px; line-height: 1.2; word-break: break-word; mso-line-height-alt: 12px; margin: 0;\"><span style=\"font-size: 10px;\">www.caringforcarehomes.com</span></p>\n" + 
			"</div>\n" + 
			"</div>\n" + 
			"<!--[if mso]></td></tr></table><![endif]-->\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\n" + 
			"</div>\n" + 
			"<!--<![endif]-->\n" + 
			"</div>\n" + 
			"</div>\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + 
			"</div>\n" + 
			"</div>\n" + 
			"</div>\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" + 
			"</td>\n" + 
			"</tr>\n" + 
			"</tbody>\n" + 
			"</table>\n" + 
			"<!--[if (IE)]></div><![endif]-->\n" + 
			"\n" + 
			"</body></html>";

	private String getTemplate() {
		return template;
	}
	
	public String getSubstitutedTemplate(EmailRequest emailRequest, String nonGuessableId) {
		return getSubstitutedTemplate(emailRequest, nonGuessableId, true);
	}
	
	public String getSubstitutedTemplate(EmailRequest emailRequest, String nonGuessableId, boolean addLinks) {
    	String template = this.getTemplate();
    	template = template.replace("[users_email]", emailRequest.getCareHomeEmail());
    	template = template.replace("[medication]", "\'" + emailRequest.getMedicationName() + "\'");
    	template = template.replace("[resident]", emailRequest.getResidentName());
    	template = template.replace("[users_name]", emailRequest.getUsersName());
    	template = template.replace("[care_home_name]", emailRequest.getCareHomeName());
    	if (addLinks) {
	    	template = template.replace("[href_accept]", frontEndUrl + "/email/set-date?" + nonGuessableId); //http://localhost:3000/email/confirmation?vb4nqCj3VUCpA7Xr7Mvo
	    	template = template.replace("[href_inquiry]", frontEndUrl + "/email/inquiry?" + nonGuessableId);
    	} else {
    		template = template.replace("href=\"[href_accept]\"", "");
    		template = template.replace("href=\"[href_inquiry]\"", "");
    	}
    	
    	String pattern = "dd-MM-yyyy";
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	template = template.replace("[date]", sdf.format(emailRequest.getCycleEndDate()));
    	return template;
	}
	
}
