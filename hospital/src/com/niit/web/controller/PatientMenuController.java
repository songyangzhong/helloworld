package com.niit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientMenuController {
	
	//这里/不是表示所有请求,而是表示应用程序上下文路径
    //控制器中的一个方法可以对应多个请求url
    @RequestMapping({"/patient/index","/patient"})
    public String index(){
        return "patient/index";
    }
    
    @RequestMapping("/patient/error")
    public String patienterror(){
        return "/patient/error"; 
    }
    
    @RequestMapping("patient/left")
    public String left(){
        return "patient/left"; 
    }
    
    @RequestMapping("patient/head")
    public String head(){
        return "patient/head";
    }
    
    @RequestMapping("patient/main")
    public String main(){
        return "patient/main"; 
    }

    @RequestMapping("patient/login")
    public String login(){
        return "patient/login";
    }
    
    @RequestMapping("patient/register")
    public String register(){
        return "patient/register";
    }
    
}
