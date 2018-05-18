package com.niit.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Case;
import com.niit.service.ICaseService;

@Controller
@RequestMapping("case")
public class CaseController {
	
	@Resource
	private ICaseService caseService;
	
	@RequestMapping("findByPatientId")
    public ModelAndView findByPatientId(HttpServletRequest request){
		//------
		//从Session中获取病人信息
		//request.getSession().equals("patient");
		int patientId = 1;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("patient/case");
		List<Case> cases = caseService.findByPatientId(patientId);
		System.out.println(cases.get(0).getPatientByPatientId().getPatientName());
		mv.addObject("cases", cases);
        return mv; 
    }
}
