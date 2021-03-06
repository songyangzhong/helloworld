package com.niit.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Doctor;
import com.niit.model.Inspect;
import com.niit.model.Patient_Inspect;
import com.niit.service.IDoctorService;
import com.niit.service.IPatientService;
import com.niit.util.MD5keyBean;
import com.niit.web.form.PatientForm;

@Controller
@RequestMapping("patient")
public class PatientController {

	@Resource
	private IPatientService patientService;
	@Resource
	private IDoctorService doctorService;

	@RequestMapping("findPatientByPatientId")
	public ModelAndView findPatientByPatientId(HttpServletRequest request) {
		PatientForm patientForm = (PatientForm) request.getSession().getAttribute("patientForm");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("patient/patientTab");
		mv.addObject("patientForm", patientForm);
		return mv;
	}

	@RequestMapping("deleteById")
	public String deleteById(int patientId) {
		patientService.deleteById(patientId);
		return "redirect:findAll";
	}

	@RequestMapping("beforeUpdate")
	public ModelAndView beforeUpate(HttpServletRequest request) {
		PatientForm patientForm = (PatientForm) request.getSession().getAttribute("patientForm");

		ModelAndView mv = new ModelAndView();
		mv.addObject("patientForm", patientForm);
		mv.setViewName("patient/patientUpdate");
		return mv;
	}

	@RequestMapping("patientUpdate")
	public String patientUpdate(HttpServletRequest request, PatientForm patientForm) {
		Date createTime = new Date(System.currentTimeMillis());
		patientForm.setCreateTime(createTime);

		patientService.update(patientForm);
		request.getSession().setAttribute("patientForm", patientForm);

		return "redirect:/patient/findPatientByPatientId";
	}

	@RequestMapping("patientRegister")
	public String register(PatientForm patientForm, HttpServletRequest request) {
		Date createTime = new Date(System.currentTimeMillis());
		patientForm.setCreateTime(createTime);
		// md5
		MD5keyBean md5keyBean = new MD5keyBean();
		Random rand = new Random();
		byte ib = (byte) rand.nextInt(128);
		String salt = MD5keyBean.byteHEX(ib);
		patientForm.setSalt(salt);
		String md5_password = md5keyBean.getkeyBeanofStr(patientForm.getPassword() + salt);
		patientForm.setPassword(md5_password);
		//
		int patientId = patientService.save(patientForm);
		patientForm.setPatientId(patientId);
		request.getSession().setAttribute("patientForm", patientForm);
		return "redirect:/patient/index";
	}

	@RequestMapping("patientLogin")
	public ModelAndView login(PatientForm patientForm, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		patientForm = patientService.login(patientForm);
		if (patientForm != null) {
			request.getSession().setAttribute("patientForm", patientForm);
			mv.setViewName("redirect:/patient/index");
			return mv;
		} else {
			mv.setViewName("forward:/patient/login");
			mv.addObject("message", "用户名或密码错误");
			return mv;
		}
	}

	@RequestMapping("findInspectByPatientId")
	public ModelAndView findInspectByPatientId(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		PatientForm patientForm = (PatientForm) request.getSession().getAttribute("patientForm");
		List<Patient_Inspect> patient_Inspects = patientService.findInspectByPatientId(patientForm.getPatientId());
		mv.addObject("patientForm", patientForm);
		mv.addObject("patient_Inspects", patient_Inspects);

		mv.setViewName("/patient/inspect");
		return mv;
	}

	@RequestMapping("/findPatientsByDoctorId")
	public String findPatientsByDoctorId(int doctorId, Model model) {
		Doctor doctor = doctorService.findDoctorById(doctorId);
		model.addAttribute("patients", doctor.getPatients());
		return "doctor_patient";
	}

}
