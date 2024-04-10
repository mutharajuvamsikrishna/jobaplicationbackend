package com.web.service;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.web.model.Pro;
import com.web.repo.ProRepo;
import com.web.repo.RegisterRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmailService mailSender;
	@Autowired
	private RegisterRepo repo;
	@Autowired
	private ProRepo proRepo;
@Value("${adminemail}")
private String adminEmail;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Scheduled(cron = "0 44 14 * * ?")
	public void sendReminders() throws MessagingException {
		Date currentDate = new Date();
		List<Pro> items = proRepo.findByPrevCompanyName2(currentDate);

		for (Pro action : items) {
			sendMail(action);
		}
	}

	// method to send reminders to users
	public void sendMail(Pro action) throws MessagingException {
		Long applicationId = action.getRegno();
		String interviewDate = action.getPrevCompanyName2();
		String email = action.getEmail();
		String jobAppliedFor = action.getId();
		String companyName = "ONiE Soft"; // Replace with your actual company name

		// User email
		String applicantSubject = "Interview Reminder - " + companyName + " - Application ID: " + applicationId;
		String applicantBody = "Dear Applicant,\n\nThis is a reminder for your upcoming interview on " + interviewDate
				+ " for the position of " + jobAppliedFor + ". Your application ID is: " + applicationId
				+ ". Good luck!";
		mailSender.sendEmail(email, applicantSubject, applicantBody);

		// Admin email
		String adminSubject = "Interview Reminder - " + companyName + " - Application ID: " + applicationId;
		String adminBody = "Admin, \n\nA reminder has been sent to the applicant with email " + email
				+ " for the interview scheduled on " + interviewDate + " for the position of " + jobAppliedFor
				+ ". Application ID: " + applicationId + ".";
		mailSender.sendEmail(adminEmail, adminSubject, adminBody);
	}

}
