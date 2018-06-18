package com.niit.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.model.Patient;
import com.niit.service.IPatientService;
import com.niit.test.JuheDemo;
import com.niit.web.form.PatientForm;

import net.sf.json.JSONObject;

@Controller
public class SmsController {

    @Resource
    private IPatientService patientService;
    
    @RequestMapping("updatePassword")
    public String updatePassword(String password,String code,HttpServletRequest request){
    	//测试代码，需要删除
    	Patient patient2 = patientService.findByPhone("17863900096");
    	request.getSession().setAttribute("patient",patient2);
    	//
    	Patient patient = (Patient) request.getSession().getAttribute("patient");
    	if(patient == null) {
    		return "/patient/findPassword";
    	}
    	PatientForm patientForm = new PatientForm();
    	patientForm.setAge(patient.getAge());
		patientForm.setCreateTime(patient.getCreateTime());
		patientForm.setDietAdvice(patient.getDietAdvice());
		patientForm.setGender(patient.getGender());
		patientForm.setMedicineHistory(patient.getMedicineHistory());
		patientForm.setPassword(password);
		patientForm.setPatientId(patient.getPatientId());
		patientForm.setPatientName(patient.getPatientName());
		patientForm.setPhoneNumber(patient.getPhoneNumber());
		patientForm.setWardId(patient.getWardId());
		patientForm.setInspects(patient.getInspects());
		patientForm.setSalt(patient.getSalt());
		patientForm.setDoctors(patient.getDoctors());
    	patientService.update(patientForm);
    	
    	request.getSession().setAttribute("patientForm", patientForm);
    	return "redirect:/patient/index";
    }
    
    @RequestMapping("findPassword")
    public String findPassword(){
    	return "/patient/findPassword";
    }

    @RequestMapping("SendSms")
    @ResponseBody
    public String SmsServlet(String phone,HttpServletRequest request,HttpServletResponse response) throws ServletException, UnsupportedEncodingException{
    	System.out.println("phone: " + phone);
    	
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        Patient patient = patientService.findByPhone(phone);
        request.getSession().setAttribute("patient",patient);
		
		String strUrl = "http://v.juhe.cn/sms/send";// 请求接口地址
		Map params = new HashMap();// 请求参数
		params.put("mobile", phone);// 接收短信的手机号码
		params.put("tpl_id", 83083);// 短信模板ID，请参考个人中心短信模板设置
		params.put("tpl_value", "%23code%23%3D654654");// 变量名和变量值对。如果你的变量名或者变量值中带有#&=中的任意一个特殊符号，请先分别进行urlencode编码后再传递，<a
									// href="http://www.juhe.cn/news/index/id/50" target="_blank">详细说明></a>
		params.put("key", JuheDemo.APPKEY);// 应用APPKEY(应用详细页查询)
		params.put("dtype", "json");// 返回数据的格式,xml或json，默认json

		String method = "GET";
		if(phone!=null&&phone!="") {
			try {
	            String result = JuheDemo.net(strUrl, params, "GET");
	            System.out.println("--------------------------------------------------------");
	            System.out.println("已发送");
	            System.out.println("--------------------------------------------------------");
	            JSONObject object = JSONObject.fromObject(result);
	            if(object.getInt("error_code")==0){
	                System.out.println(object.get("result"));
	                return "true";
	            }else{
	                System.out.println(object.get("error_code")+":"+object.get("reason"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}

        return "false";
    }

}
