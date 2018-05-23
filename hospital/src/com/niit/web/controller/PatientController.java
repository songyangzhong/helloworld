package com.niit.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Patient;
import com.niit.service.IPatientService;
import com.niit.service.impl.PatientServiceImpl;
import com.niit.web.form.PatientForm;

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
		PatientForm patientForm = patientService.findById(patientId);
		mv.addObject("patientForm", patientForm);
        return mv; 
    }
	
	@RequestMapping("deleteById")
    public String deleteById(int patientId){
		patientService.deleteById(patientId);
        return "redirect:findAll"; 
    }
	
	@RequestMapping("beforeUpdate")
    public ModelAndView beforeUpate(HttpServletRequest request){
		//---------
		//从Session中获取patient
		//request.getSession().getAttribute("patient");
		int patientId = 1;
		
		PatientForm patientForm = patientService.findById(patientId);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("patientForm",patientForm);
		mv.setViewName("patient/patientUpdate");
        return mv; 
    }
	
	@RequestMapping("patientUpdate")
    public String patientUpdate(HttpServletRequest request,PatientForm patientForm){
		//---------
		//从Session中获取patient
		//request.getSession().getAttribute("patient");
		int patientId = 1;
		
		Date createTime = new Date(System.currentTimeMillis());
		patientForm.setCreateTime(createTime);
		patientService.update(patientForm);
		
        return "redirect:/patient/findPatientByPatientId"; 
    }
	
	@RequestMapping("patientRegister")
    public String register(PatientForm patientForm,HttpServletRequest request){
		Date createTime = new Date(System.currentTimeMillis());
		patientForm.setCreateTime(createTime);
		patientForm.setSalt("132");
		int patientId = patientService.save(patientForm);
		patientForm.setPatientId(patientId);
		request.getSession().setAttribute("patientForm", patientForm);
        return "redirect:/patient/index"; 
    }
	
	@RequestMapping("patientLogin")
    public String login(PatientForm patientForm,HttpServletRequest request){
		request.getSession().setAttribute("patientForm", patientForm);
        return "redirect:/patient/index"; 
    }
	
	
}
