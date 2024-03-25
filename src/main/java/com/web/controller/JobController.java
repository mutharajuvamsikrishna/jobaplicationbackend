package com.web.controller;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dto.PerEmpResponseDTO;
import com.web.model.Register;
import com.web.service.PerEmpService;

import com.web.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.OnieJobId;
import com.web.model.PerEmp;
import com.web.model.Pro;
import com.web.repo.OnieJobIdRepo;
import com.web.repo.PerEmpRepo;
import com.web.repo.ProRepo;
import com.web.service.ApplicationService;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class JobController {
	@Autowired
	ApplicationService appliService;
	@Autowired
	ProRepo proRepo;
	@Autowired
	PerEmpRepo repo;
	@Autowired
	OnieJobIdRepo jobRepo;
	@Autowired
	private PerEmpRepo perEmpRepository;
@Autowired
private JwtUtil jwtUtil;
@Value("${applicationport}")
private String frontendport;


	@GetMapping("/loginoauth")
	public ResponseEntity<Object> loginOauth(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Register userEntity = (Register) session.getAttribute("userEntity");
		System.out.println("UserEntity in controller: " + userEntity);

		// Generate token
		String token = jwtUtil.generateToken(userEntity.getEmail());
		System.out.println("Generated Token: " + token);

		// Redirect to the URL and include the token and email as query parameters
		String redirectUrl = frontendport + token + "&email=" + userEntity.getEmail();
		System.out.println("Redirect URL: " + redirectUrl);
		return ResponseEntity.status(HttpStatus.FOUND)
				.location(URI.create(redirectUrl))
				.build();
	}


	@PostMapping("/prosave")
	public String proSavecont(@RequestBody Pro pro) throws MessagingException {

		return appliService.proSave(pro);
	}

	@GetMapping("/userreq")
	public List<Pro> getPros() {
		return proRepo.findAll();
	}

	@Autowired
	private PerEmpService perEmpService;


	@PostMapping("/persave")
	public ResponseEntity<String> savePerEmpWithFiles(
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "aadhar", required = false) String aadhar,
			@RequestParam(value = "pan", required = false) String pan,
			@RequestParam(value = "val1", required = false) String val1,
			@RequestParam(value = "status1", required = false) String status1,
			@RequestParam(value = "passportnumber", required = false) String passportnumber,
			@RequestParam(value = "exp1", required = false) String exp1,
			@RequestParam(value = "val2", required = false) String val2,
			@RequestParam(value = "status2", required = false) String status2,
			@RequestParam(value = "visanumber", required = false) String visanumber,
			@RequestParam(value = "exp2", required = false) String exp2,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "pinnumber", required = false) String pinnumber,
			@RequestParam(value = "aadharFile", required = false) MultipartFile aadharFile,
			@RequestParam(value = "panFile", required = false) MultipartFile panFile,
			@RequestParam(value = "passportFile", required = false) MultipartFile passportFile,
			@RequestParam(value = "visaFile", required = false) MultipartFile visaFile,
			@RequestParam(value = "otherFile", required = false) MultipartFile otherFile) {

		try {
			PerEmp perEmp = new PerEmp();
			// Set other fields in the PerEmp entity...
			perEmp.setEmail(email);
			perEmp.setAdhar(aadhar);
			perEmp.setPan(pan);
			perEmp.setVal1(val1);
			perEmp.setStatus1(status1);
			perEmp.setPassportnumber(passportnumber);
			perEmp.setExp1(exp1);
			perEmp.setVal2(val2);
			perEmp.setStatus2(status2);
			perEmp.setVisanumber(visanumber);
			perEmp.setExp2(exp2);
			perEmp.setGender(gender);
			perEmp.setDate(date);
			perEmp.setAdress(address);
			perEmp.setCity(city);
			perEmp.setState(state);
			perEmp.setPinnumber(pinnumber);
System.out.println(aadharFile);
			perEmpService.savePerEmpWithFiles(perEmp, aadharFile, panFile, passportFile, visaFile, otherFile);
			return ResponseEntity.status(HttpStatus.CREATED).body("PerEmp saved successfully!");
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving PerEmp with files.");
		}
	}
	@PutMapping("/updateDetails")
	public ResponseEntity<String> upDatePerEmpWithFiles(
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "aadhar", required = false) String aadhar,
			@RequestParam(value = "pan", required = false) String pan,
			@RequestParam(value = "val1", required = false) String val1,
			@RequestParam(value = "status1", required = false) String status1,
			@RequestParam(value = "passportnumber", required = false) String passportnumber,
			@RequestParam(value = "exp1", required = false) String exp1,
			@RequestParam(value = "val2", required = false) String val2,
			@RequestParam(value = "status2", required = false) String status2,
			@RequestParam(value = "visanumber", required = false) String visanumber,
			@RequestParam(value = "exp2", required = false) String exp2,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "pinnumber", required = false) String pinnumber,
			@RequestParam(value = "aadharFile", required = false) MultipartFile aadharFile,
			@RequestParam(value = "panFile", required = false) MultipartFile panFile,
			@RequestParam(value = "passportFile", required = false) MultipartFile passportFile,
			@RequestParam(value = "visaFile", required = false) MultipartFile visaFile,
			@RequestParam(value = "otherFile", required = false) MultipartFile otherFile) {

		try {
			PerEmp perEmp=perEmpRepository.findByEmail(email);
			perEmp.setRegno(perEmp.getRegno());
			perEmp.setEmail(email);
			perEmp.setAdhar(aadhar);
			perEmp.setPan(pan);
			perEmp.setVal1(val1);
			perEmp.setStatus1(status1);
			perEmp.setPassportnumber(passportnumber);
			perEmp.setExp1(exp1);
			perEmp.setVal2(val2);
			perEmp.setStatus2(status2);
			perEmp.setVisanumber(visanumber);
			perEmp.setExp2(exp2);
			perEmp.setGender(gender);
			perEmp.setDate(date);
			perEmp.setAdress(address);
			perEmp.setCity(city);
			perEmp.setState(state);
			perEmp.setPinnumber(pinnumber);
			System.out.println(aadharFile);
			perEmpService.savePerEmpWithFiles(perEmp, aadharFile, panFile, passportFile, visaFile, otherFile);
			return ResponseEntity.status(HttpStatus.CREATED).body("PerEmp saved successfully!");
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving PerEmp with files.");
		}
	}


	@GetMapping(value = "/useruniquereq", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PerEmpResponseDTO> getUniqueUser(@RequestParam String email) {
		PerEmp emp = repo.findByEmail(email);

		if (emp != null) {
			List<String> filePaths = getFilePathsForPerEmp(emp);
			List<byte[]> fileContents = getFileContents(filePaths);

			PerEmpResponseDTO responseDTO = new PerEmpResponseDTO();
			responseDTO.setRegno(emp.getRegno());
			responseDTO.setEmail(emp.getEmail());
			responseDTO.setAdhar(emp.getAdhar());
			responseDTO.setPan(emp.getPan());
			responseDTO.setVal1(emp.getVal1());
			responseDTO.setStatus1(emp.getStatus1());
			responseDTO.setPassportnumber(emp.getPassportnumber());
			responseDTO.setExp1(emp.getExp1());
			responseDTO.setVal2(emp.getVal2());
			responseDTO.setStatus2(emp.getStatus2());
			responseDTO.setVisanumber(emp.getVisanumber());
			responseDTO.setExp2(emp.getExp2());
			responseDTO.setGender(emp.getGender());
			responseDTO.setDate(emp.getDate());
			responseDTO.setAddress(emp.getAdress());
			responseDTO.setCity(emp.getCity());
			responseDTO.setState(emp.getState());
			responseDTO.setPinnumber(emp.getPinnumber());
			responseDTO.setFilePaths(filePaths);
			responseDTO.setFileContents(fileContents);

			return ResponseEntity.ok(responseDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	private List<String> getFilePathsForPerEmp(PerEmp perEmp) {
		List<String> filePaths = new ArrayList<>();
		filePaths.add(perEmp.getAadharFile());
		filePaths.add(perEmp.getPanFile());
		filePaths.add(perEmp.getPassportFile());
		filePaths.add(perEmp.getVisaFile());
		filePaths.add(perEmp.getOtherFile());
		filePaths.stream().forEach(e->System.out.println(e));
		return filePaths;
	}

	private List<byte[]> getFileContents(List<String> filePaths) {
		List<byte[]> fileContents = new ArrayList<>();
		for (String filePath : filePaths) {
			if (filePath != null) {
				try {
					byte[] content = Files.readAllBytes(Paths.get(filePath));
					fileContents.add(content);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileContents;
	}


	@GetMapping("/perinfo")
	public List<PerEmp> getPersonal() {
		return repo.findAll();
	}

	@DeleteMapping(value = "/deleteappli") // edited /per455
	public String deleteAdmin(@RequestParam Long regno) {
		proRepo.deleteById(regno);
		return "Deleted Sucess Fully";

	}

	@GetMapping("/search")

	public List<Pro> searchPro(@RequestParam("query") String query, Model model) {
		List<Pro> users1 = proRepo.searchPro(query);
		model.addAttribute("users1", users1);
		return users1;
	}

	@PutMapping("/usereditupdate")
	public String adminAppliactionUpdate(@RequestBody Pro pro) throws MessagingException {
		return appliService.proUpdate(pro);
	}

	@PostMapping("/addjobid")
	public String addOnieJobId(@RequestBody OnieJobId id) {
		jobRepo.save(id);
		return "addsuccessfully";
	}

	@DeleteMapping("/deletejobid")
	public String deleteOnieJobId(@RequestParam Long id) {
		jobRepo.deleteById(id);
		return "deletedsuccess";
	}

	@GetMapping("/getjobid")
	public ArrayList<OnieJobId> getAllJobId() {
		return jobRepo.findAll();
	}
}
