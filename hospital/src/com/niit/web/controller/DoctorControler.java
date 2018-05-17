package com.niit.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Doctor;
import com.niit.service.IDoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorControler {
	@Resource
	private IDoctorService doctorService;
	
	@RequestMapping("/findAll")
	public String findAll(Model model){
		List<Doctor> all = doctorService.findAll();
		model.addAttribute("list",all);
		return "doctTab";
	}
	
	@RequestMapping("/deleteDoctorById")
	public String deleteDoctor(Integer id){
		doctorService.deleteDoctorById(id);
		return "forward:findAll";
	}

}
