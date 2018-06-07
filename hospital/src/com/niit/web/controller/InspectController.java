package com.niit.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Inspect;
import com.niit.service.IInspectService;

@Controller()
@RequestMapping("/inspect")
public class InspectController {
	@Resource
	private IInspectService inspectService;
	
	@RequestMapping("/findAll")
    public ModelAndView findAll(){
		List<Inspect> inspects = inspectService.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/inspect");
		mv.addObject("inspects", inspects);
        return mv;
    }
	
	@RequestMapping("/delete")
    public String delete(int inspectId){
		inspectService.deleteById(inspectId);
		return "redirect:/inspect/findAll";
    }
	
}
