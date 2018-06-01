package com.niit.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.print.Doc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Department;
import com.niit.model.Doctor;
import com.niit.service.IDepartmentService;
import com.niit.service.IDoctorService;
import com.niit.util.MD5keyBean;

@Controller
@RequestMapping("/doctor")
public class DoctorControler {
	@Resource
	private IDoctorService doctorService;
	
	@Resource
	private IDepartmentService  departmentService;
	
	
	@RequestMapping("/login")
	public String login(String doctorName ,String password){
		return password;
		
	}
	
	
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
	
	
	@RequestMapping("/register")
	public String register(Doctor doctor,Integer departmentId){
		Department department = this.departmentService.findDepartmentById(departmentId);
		doctor.setPassword(new MD5keyBean().getkeyBeanofStr(doctor.getPassword()));
		doctor.setCreateTime(new Date());
		doctor.setDepartmentByDepartmentId(department);
		department.getDoctorsByDepartmentId().add(doctor);
		return "/index";	
	}
	
	@RequestMapping("/updateDoctor_toTab")
	public String updateDoctor_toTab(Integer id,Model model){
		Doctor doctor = doctorService.findDoctorById(id);
		model.addAttribute("doctor",doctor);
		return "updateDoctor";
		
	}
	
	@RequestMapping("/updateDoctor")
	public String updateDoctor_toTab(Doctor doctor){
		doctorService.updateDoctor(doctor);
		return "forward:findAll";
	}

}
