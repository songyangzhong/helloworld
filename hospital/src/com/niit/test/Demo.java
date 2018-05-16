package com.niit.test;

import java.sql.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.niit.model.UserTest;
import com.niit.model.Ward;
import com.niit.service.IUserService;
import com.niit.service.impl.WardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class Demo {

	@Resource(name = "userService")
	private IUserService userService;
	@Resource(name = "wardService")
	private WardService wardService;

	@Test
	public void test3() {
		UserTest u = new UserTest();
		u.setName("test-name");
		u.setGender("test-gender");
		userService.save(u);
	}
	
	@Test
	public void test() { 
		Ward ward = new Ward();
		Date date = new Date(System.currentTimeMillis());
		ward.setCreateTime(date);
		wardService.save(ward);
	}

}
