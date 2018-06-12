package com.niit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Doctor;
import com.niit.web.form.PatientForm;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	// 方法前调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// 判断用户是否登陆 如果没有登陆 重定向到登陆页面 不放行 如果登陆了 就放行了
		// URL http://localhost:8080/springmvc-mybatis/login.action
		// URI /login.action
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		if (!requestURI.contains("error") && !requestURI.contains("login") && !requestURI.contains("Login")
				&& !requestURI.contains("register") && !requestURI.contains("Register")) {
			Doctor doctor = (Doctor) request.getSession().getAttribute("doctor");
			PatientForm patientForm = (PatientForm) request.getSession().getAttribute("patientForm");
			if (doctor != null || patientForm != null) {
				return true;
			} else if (requestURI.contains("doctor") || requestURI.contains("findAll")) {
				// response.sendRedirect(request.getContextPath() + "/doctor/login");
				request.setAttribute("error", "未登录");
				request.getRequestDispatcher("/doctor/error").forward(request, response);
				return false;
			} else if (requestURI.contains("patient") || requestURI.contains("Patient")) {
				// response.sendRedirect(request.getContextPath() + "/patient/login");
				request.setAttribute("error", "未登录");
				request.getRequestDispatcher("/patient/error").forward(request, response);
				return false;
			}
		}
		return true;
	}

}
