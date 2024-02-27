package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("/prosave")
	public String proSavecont(@RequestBody Pro pro) throws MessagingException {

		return appliService.proSave(pro);
	}

	@GetMapping("/userreq")
	public List<Pro> getPros() {
		return proRepo.findAll();
	}

	@PostMapping("/persave")
	public String PersonalAppliSave(@RequestBody PerEmp emp) {

		return appliService.personalDetails(emp);

	}

	@GetMapping("/useruniquereq")
	public PerEmp getUniqueUser(@RequestParam String email) {

		PerEmp emp = repo.findByEmail(email);
		if (emp != null)
			return emp;
		else {
			return null;
		}
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
