package com.web.controller;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Otp;
import com.web.model.Register;
import com.web.model.Register1;
import com.web.repo.OtpRepo;
import com.web.repo.ProRepo;
import com.web.repo.Register1Repo;
import com.web.repo.RegisterRepo;

@RestController

public class ViewallController {

	@Autowired
	private ProRepo repo1;

	@Autowired
	private RegisterRepo repo7;
	@Autowired
	private OtpRepo otprepo;

	@Autowired
	private Register1Repo repo8;
	@Value("${adminemail}")
	private String adminEmail;
	@PostMapping("/changepassword")
	public ResponseEntity<?> changepassword(@RequestBody

											Register customer) {
		String email = customer.getEmail();

		String mob = customer.getMob();
		System.out.println(email);
		System.out.println(mob);
		Register reg = repo7.findByEmailAndMob(email, mob);

		if (reg == null) {
			System.out.println("reg Is Null");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found to Given Email and Mobile Number");
		} else {
			System.out.println("reg Is Not Null");
			String ename = reg.getEname();

// Generate OTP
			String otp = generateOTP();
			String otpId = UUID.randomUUID().toString();
			if (otp == null) {
				System.out.println("otp Is NotNull" + otp);
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("OTP is Null");
			} else {
				System.out.println("otp Is Not Null" + otp);

			}
// Save the OTP to the database using the Otp class

			Otp otpEntity = new Otp(otpId, otp);
			otprepo.save(otpEntity);

			try {
				// Send OTP via email
				sendEmail3(email, "ONiESoft JobApplication ChangePassword OTP Verification",
						"Hello " + ename + ",\n\nYour OTP is: " + otp + " and it is valid for 5 minutes.");
				System.out.println("Email sent successfully.");
			} catch (MessagingException e) {
				// Handle any exceptions that occurred during email sending
				e.printStackTrace();
				System.out.println("Exception");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email Could Not be Sent");
			}
			System.out.println("Ok");
			return ResponseEntity.ok(reg);
		}
	}



	@PostMapping("/otp5")
	public String submitOTP1(@RequestParam String otp, ModelMap model) {

		if (otp == null) {
			System.out.println("otp is null1");
		} else {
			System.out.println("otp is Entered" + otp);
		}

		Otp otp2 = otprepo.findByOtpValue(otp);
		if (otp2 == null) {
			return "changeinotp";
		}
		String otp3 = otp2.getOtpValue();
		if (otp != null) {
			System.out.println("Stored otp is not null" + otp3);
		}

// Check if newRegister object is found in the session and OTP is correct
		if (otp != null && otp.equals(otp3)) {
			// Save the newRegister object using the repository

			otprepo.delete(otp2);
			return "changeregsucess";
		} else {
			// newRegister object not found in session or OTP is incorrect, return
			// registration failure page
			return "changeinotp";
		}
	}

//admin start

	@PutMapping("/changepassword1")
	public String updatePassword(@RequestBody Register reg) {
		String email = reg.getEmail();

		String password1 = reg.getPassword();
		String cnpassword = reg.getCnpassword();
		Register emp = repo7.findByEmail(email);

		if (emp != null) {
			emp.setPassword(password1);
			repo7.save(emp);

			return "savesuceess1";

		} else {
			return "fail";
		}
	}

//admin start

	@PostMapping("/adminchangepassword")
	public ResponseEntity<?> adminchangepassword(@RequestBody

												 Register1 customer) {
		String email = customer.getEmail();

		String mob = customer.getMob();

		Register1 reg = repo8.findByEmailAndMob(email, mob);

		if (reg == null) {
			System.out.println("reg Is Null");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("User Not Found Provided By Mobile Number And Email");

		} else {
			System.out.println("reg Is Not Null");
			String ename = reg.getEname();

// Generate OTP
			String otp = generateOTP();
			String otpId = UUID.randomUUID().toString();
			if (otp == null) {
				System.out.println("otp Is NotNull" + otp);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OTP is Null");
			} else {
				System.out.println("otp Is Not Null" + otp);

			}
// Save the OTP to the database using the Otp class

			Otp otpEntity = new Otp(otpId, otp);
			otprepo.save(otpEntity);


			try {
				// Send OTP via email
				sendEmail3(email, "ONiESoft  JobApplication Admin Change Password OTP Verification",
						"Hello " + ename + ",\n\nYour OTP is: " + otp + " and it is valid for 5 minutes.");
				System.out.println("Email sent successfully.");
			} catch (MessagingException e) {
				// Handle any exceptions that occurred during email sending
				e.printStackTrace();
				System.out.println("Exception");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OTP Error");
			}
			System.out.println("Ok");
			return ResponseEntity.ok(reg);
		}
	}

//otp validatio

// ...

	@PostMapping("/adminotp5")
	public String adminsubmitOTP1(@RequestParam String otp, ModelMap model) {

		if (otp == null) {
			System.out.println("otp is null1");
		} else {
			System.out.println("otp is Entered" + otp);
		}

		Otp otp2 = otprepo.findByOtpValue(otp);
		if (otp2 == null) {
			return "changeinotp";
		}
		String otp3 = otp2.getOtpValue();
		if (otp != null) {
			System.out.println("Stored otp is not null" + otp3);
		}

// Check if newRegister object is found in the session and OTP is correct
		if (otp != null && otp.equals(otp3)) {
			// Save the newRegister object using the repository

			otprepo.delete(otp2);
			return "adminchangeregsucess";
		} else {
			// newRegister object not found in session or OTP is incorrect, return
			// registration failure page
			return "changeinotp";
		}
	}

	@PutMapping("/adminchangepassword1")
	public String adminupdatePassword(@RequestBody Register reg) {
		String email = reg.getEmail();

		String password1 = reg.getPassword();
		String cnpassword = reg.getCnpassword();
		Register1 emp = repo8.findByEmail(email);

		if (emp != null) {
			emp.setPassword(password1);
			repo8.save(emp);

			return "adminchangepassword";

		}

		else {
			return "regfail";
		}
	}

	private String generateOTP() {
		// Generate a random 6-digit OTP
		int otp = (int) (Math.random() * 900000) + 100000;
		return String.valueOf(otp);

	}

	private void sendEmail3(String recipientEmail, String subject, String body) throws MessagingException {
		// Replace with your email and password
String email="slrvamsikrishna@gmail.com";
		String senderPassword = "zugweogflidhqcyi";

		// Set properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// Create session
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senderPassword);
			}
		});

		// Create message
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
		message.setSubject(subject);
		message.setText(body);

		// Send message
		Transport.send(message);
		System.out.println("Email sent successfully.");
	}

//

}
