package com.niit.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Case;
import com.niit.model.Department;
import com.niit.model.Doctor;
import com.niit.model.Patient;
import com.niit.service.ICaseService;
import com.niit.service.IDepartmentService;
import com.niit.service.IDoctorService;
import com.niit.service.IPatientService;
import com.niit.service.impl.PatientServiceImpl;
import com.niit.util.MD5keyBean;
import com.niit.web.form.PatientForm;

@Controller
@RequestMapping("/doctor")
public class DoctorControler {
	@Resource
	private IDoctorService doctorService;
	
	@Resource
	private IPatientService patientService;
	
	@Resource
	private IDepartmentService  departmentService;
	
	@Resource
	private ICaseService caseService;
	
	@RequestMapping("/doctorLogin")
	public String doctorLogin(String doctorName,String password,Model model,HttpServletRequest request){
		Doctor doctor = doctorService.login(doctorName,password);
		if(doctor!=null) {
			request.getSession().setAttribute("doctor",doctor);
			return "redirect:/index";
		}else {
			model.addAttribute("message","用户名或密码错误");
			return "forward:/doctor/login";
		}
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
	
	
	@RequestMapping("/doctorRegister")
	public String register(Doctor doctor,Integer departmentId,HttpServletRequest request){
		Department department = this.departmentService.findDepartmentById(departmentId);
		doctor.setCreateTime(new Date());
		doctor.setDepartmentByDepartmentId(department);
		department.getDoctorsByDepartmentId().add(doctor);
		Doctor saveDoctor = doctorService.saveDoctor(doctor);
		request.getSession().setAttribute("doctor", saveDoctor);
		return "/index";
	}
	
	@RequestMapping("/updateDoctor_toTab")
	public String updateDoctor_toTab(Integer id,Model model){
		Doctor doctor = doctorService.findDoctorById(id);
		model.addAttribute("doctor",doctor);
		return "updateDoctor";
		
	}
	
	@RequestMapping("/updateDoctor")
	public String updateDoctor_toTab(Doctor doctor,HttpServletRequest request){
		Doctor updateDoctor = doctorService.updateDoctor(doctor);
		request.getSession().setAttribute("doctor",updateDoctor);
		return "forward:findAll";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request,Model model){
		List<Department> departments = departmentService.findAll();
		model.addAttribute("departments", departments);
		return "register";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/findAllPatients")
	public String findAllPatients(Model model){
		List<Patient> patients = patientService.findAll();
		model.addAttribute("patients", patients);
		return "patientTab";
	}
	
	@RequestMapping("/findAllCases")
	public String findAllCases(Model model){
		List<Case> cases = caseService.findAll();
		model.addAttribute("cases", cases);
		return "case";
	}
	
	@RequestMapping("/findDoctorsByDepartmentId")
	public String findDoctorsByDepartmentId(Integer depId,Model model){
		System.out.println(depId);
		Department department = departmentService.findDepartmentById(depId);
		model.addAttribute("doctors", department.getDoctorsByDepartmentId());
		return "doctors_depId";
	}
	
	@RequestMapping("/findDoctorsByPatientId")
	public String findPatientsByDoctorId(HttpServletRequest request,Model model) {
		PatientForm patientForm = (PatientForm) request.getSession().getAttribute("patientForm");
		model.addAttribute("doctors", patientForm.getDoctors());
		return "/patient/doctor_patient";
	}
	
}
