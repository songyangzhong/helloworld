
package com.niit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
	//这里/不是表示所有请求,而是表示应用程序上下文路径
    //控制器中的一个方法可以对应多个请求url
    @RequestMapping({"/index","/"})
    public String index(){
        return "index"; //该方法的执行最后跳转到index.jsp页面,所以给出该视图的名称
    }
    
    @RequestMapping({"/left"})
    public String left(){
        return "left"; //该方法的执行最后跳转到index.jsp页面,所以给出该视图的名称
    }
    
    @RequestMapping({"/head"})
    public String head(){
        return "head"; //该方法的执行最后跳转到index.jsp页面,所以给出该视图的名称
    }
    
    @RequestMapping({"/main"})
    public String main(){
        return "main"; //该方法的执行最后跳转到index.jsp页面,所以给出该视图的名称
    }

    @RequestMapping({"/login"})
    public String login(){
        return "login"; //该方法的执行最后跳转到index.jsp页面,所以给出该视图的名称
    }
    
    
    @RequestMapping({"/doctTab"})
    public String doctTab(){
        return "doctTab"; //该方法的执行最后跳转到index.jsp页面,所以给出该视图的名称
    }

}
