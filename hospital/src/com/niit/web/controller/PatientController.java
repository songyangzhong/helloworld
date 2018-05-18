package com.niit.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("findPatientByPatientId")
    public ModelAndView findPatientByPatientId(HttpServletRequest request){
		//-----
		//从Session中获取patient
		//request.getSession().getAttribute("patient");
		int patientId = 1;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("patient/patientTab");
		Patient patient = patientService.findById(patientId);
		mv.addObject("patient", patient);
        return mv; 
    }
	
	@RequestMapping("deleteById")
    public String deleteById(int patientId){
		patientService.deleteById(patientId);
        return "redirect:findAll"; 
    }
}
