package com.niit.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Patient;
import com.niit.service.IPatientService;
import com.niit.service.impl.PatientServiceImpl;

@Controller
@RequestMapping("patient")
public class PatientController {
	
	@Resource
	private IPatientService patientService;
	
	@RequestMapping("findAll")
    public ModelAndView findAll(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("patient/patientTab");
		List<Patient> patients = patientService.findAll();
		System.out.println(patients.get(0).getPatientName());
		mv.addObject("patients", patients);
        return mv; 
    }
	
	@RequestMapping("deleteById")
    public String deleteById(int patientId){
		patientService.deleteById(patientId);
        return "redirect:findAll"; 
    }
}
