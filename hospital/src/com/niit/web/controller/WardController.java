package com.niit.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Ward;
import com.niit.service.IWardService;

@Controller
@RequestMapping("ward")
public class WardController {
	@Resource
	private IWardService wardService;
	
	@RequestMapping("/findAll")
    public ModelAndView findAll(){
		List<Ward> wards = wardService.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/ward");
		mv.addObject("wards", wards);
        return mv;
    }
	
	@RequestMapping("/delete")
    public String delete(int wardId){
		wardService.deleteById(wardId);
		return "redirect:/ward/findAll";
    }
}
