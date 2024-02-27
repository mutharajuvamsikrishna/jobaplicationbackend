package com.web.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.web.model.PerEmp;
import com.web.model.Pro;
import com.web.model.Register;
import com.web.repo.PerEmpRepo;
import com.web.repo.ProRepo;
import com.web.repo.RegisterRepo;

@Service
public class ApplicationService {
	@Autowired
	ProRepo proRepo;
	@Autowired
	EmailService emailservice;
	@Autowired
	PerEmpRepo repo1;
	@Autowired
	RegisterRepo regRepo;

	public String proSave(@RequestBody Pro pro) throws MessagingException {
		String email = pro.getEmail();
		String jobAppliedFor = pro.getId();
		String rexpy = pro.getRexpy();
		String noticePeriod = pro.getNotice();
		Register reg = regRepo.findByEmail(email);
		String ename = reg.getEmail();
		String applicantSubject = "Your Job Application at Onie Soft";
		String applicantBody = "Dear " + ename
				+ ",\n\nThank you for applying for the position at Onie Soft. We have received your application for the job titled '"
				+ jobAppliedFor
				+ "'. We will review your application and contact you if your qualifications match our requirements.\n\nBest regards,\nThe Onie Soft Team";

		// Subject and body for the admin
		String adminSubject = "New Job Application: " + jobAppliedFor;
		String adminBody = "Dear Admin,\n\nA new job application has been submitted for the position '" + jobAppliedFor
				+ "'. Here are the details:\n\nApplicant Email: " + email + "\nRelevant Experience: " + rexpy
				+ "\nNotice Period: " + noticePeriod
				+ "\n\nPlease review the application at your earliest convenience.\n\nBest regards,\nThe Onie Soft System";

		String adminRecipientEmail = "slrvamsikrishna@gmail.com";

		emailservice.sendEmail(email, applicantSubject, applicantBody);

		emailservice.sendEmail(adminRecipientEmail, adminSubject, adminBody);
		proRepo.save(pro);
		return "SaveSucess";
	}

	public String proUpdate(@RequestBody Pro pro) throws MessagingException {
		Long regno = pro.getRegno();
		String email = pro.getEmail();
		String jobAppliedFor = pro.getId();
		String intdate = pro.getPrevCompanyName2();
		String rexpy = pro.getRexpy();
		String status = pro.getExpy();
		System.out.println(status + "status Ok");
		String noticePeriod = pro.getNotice();
		String remarks = pro.getWorkedYears2();
		String applicantSubject = "";
		String applicantBody = "";
		String adminRecipientEmail = "slrvamsikrishna@gmail.com";
		String adminSubject = "";
		String adminBody = "";
		String companyName = "ONiE Soft";
		Register reg = regRepo.findByEmail(email);
		String ename = reg.getEname();
		if ("Interview".equalsIgnoreCase(status)) {
			// Send interview email to user
			applicantSubject = "Interview Scheduled at " + companyName;
			applicantBody = "Dear " + ename + ",\n\n Your Application ID is " + regno + ". Your interview with "
					+ companyName + " is scheduled on " + intdate + ". Good luck!";
			emailservice.sendEmail(email, applicantSubject, applicantBody);
			// adminSubject = "Interview Scheduled - " + companyName;
			adminSubject = "Interview Scheduled - " + companyName;
			adminBody = "The interview for job " + jobAppliedFor + " with user " + ename + " and  Application ID is "
					+ regno + "\n" + " is scheduled on " + intdate + ".";
			emailservice.sendEmail(adminRecipientEmail, adminSubject, adminBody);
		} else if ("Rejected".equalsIgnoreCase(status)) {
			// Send rejection email to user
			applicantSubject = "Application Rejected by " + companyName;
			applicantBody = "Dear " + ename + ",\n\nWe regret to inform you that your application (Application ID No:"
					+ regno + ") for the position at " + companyName + " has been rejected." + "because of " + remarks;
			emailservice.sendEmail(email, applicantSubject, applicantBody);

			// Copy rejection email to admin
			adminSubject = "Application Rejected - " + companyName;
			adminBody = "The application for job " + jobAppliedFor + " by user " + ename + " and Application ID "
					+ regno + " has been rejected." + "because of " + remarks;
			emailservice.sendEmail(adminRecipientEmail, adminSubject, adminBody);
		}
		proRepo.save(pro);
		return "UpdateSucess";
	}

	public String personalDetails(@RequestBody PerEmp emp) {
		repo1.save(emp);
		return "sucess";
	}

}
