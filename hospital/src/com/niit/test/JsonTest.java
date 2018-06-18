package com.niit.test;

import java.util.Iterator;

import net.sf.json.JSONObject;

public class JsonTest {
	
	public static void main(String[] args) {
		String rs = "{\r\n" + 
				"	\"reason\": \"操作成功\",\r\n" + 
				"	\"result\": {\r\n" + 
				"		\"sid\": \"201806172041363733638\",\r\n" + 
				"		\"fee\": 1,\r\n" + 
				"		\"count\": 1\r\n" + 
				"	},\r\n" + 
				"	\"error_code\": 0\r\n" + 
				"}";
		JSONObject jsonObject = JSONObject.fromObject(rs);
		JSONObject jo = (JSONObject) jsonObject.get("result");
		String sid = jo.getString("sid");
		int fee = jo.getInt("fee");
		int count = jo.getInt("count");
		int error_code = (int) jsonObject.get("error_code");
		String reason = (String) jsonObject.get("reason");
		System.out.println("error_code:"+error_code);
		System.out.println("reason:"+reason);
		System.out.println("sid:"+sid);
		System.out.println("fee:"+fee);
		System.out.println("count:"+count);
	}
}
