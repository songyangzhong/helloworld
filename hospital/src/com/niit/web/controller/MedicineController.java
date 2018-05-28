package com.niit.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Medicine;
import com.niit.service.IMedicineService;

@Controller()
@RequestMapping("/medicine")
public class MedicineController {
	@Resource
	private IMedicineService medicineService;
	
	@RequestMapping("/findAll")
    public ModelAndView findAll(){
		List<Medicine> medicines = medicineService.findAll();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/medicine");
		mv.addObject("medicines", medicines);
        return mv; 
    }
	
	@RequestMapping("/delete")
    public String delete(int medicineId){
		medicineService.deleteById(medicineId);
		return "redirect:/medicine/findAll";
    }
}
