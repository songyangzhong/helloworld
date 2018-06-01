package com.niit.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception e) {
		ModelAndView mv = new ModelAndView();
		if (e instanceof CustomException) {
			CustomException ce = (CustomException) e;
			System.out.println(e);
			mv.addObject("error", ce.getMessage());
		}else {
			System.out.println(e);
			mv.addObject("error", "未知异常");
		}
		mv.setViewName("error");
		return mv;
	}
	
}
