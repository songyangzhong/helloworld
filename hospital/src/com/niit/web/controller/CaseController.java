package com.niit.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Case;
import com.niit.service.ICaseService;
import com.niit.util.CustomException;
import com.niit.web.form.PatientForm;

@Controller
@RequestMapping("case")
public class CaseController {
	
	@Resource
	private ICaseService caseService;
	
	@RequestMapping("findByPatientId")
    public ModelAndView findByPatientId(HttpServletRequest request) throws CustomException{
		PatientForm patientForm = (PatientForm) request.getSession().getAttribute("patientForm");
		if(patientForm == null) {
			throw new CustomException("未登录");
		}
		int patientId = patientForm.getPatientId();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/patient/case");
		List<Case> cases = caseService.findByPatientId(patientId);
		mv.addObject("cases", cases);
        return mv; 
    }
}
