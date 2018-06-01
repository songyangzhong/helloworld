package com.niit.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Department;
import com.niit.service.IDepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Resource
	private IDepartmentService departmentService;
	
	@RequestMapping("/findAll")
	public String findAllDepartment(Model model){
		List<Department> departments = this.departmentService.findAll();
		model.addAttribute("departments", departments);
        return "departmentTab";
	}
	
	@RequestMapping("/deleteById")
	public String findAllDepartment(Integer id){
		Department department= departmentService.findDepartmentById(id);
		this.departmentService.deleteDepartment(department);
		return "redirect:findAll";
	}
	
	
	

}
