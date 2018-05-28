package com.niit.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.niit.model.Ward;
import com.niit.service.IWardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext-dao.xml" })
public class Demo {

	@Resource(name = "wardService")
	private IWardService wardService;

//	@Test
//	public void testSave() { 
//		Ward ward = new Ward();
//		Date date = new Date(System.currentTimeMillis());
//		ward.setCreateTime(date);
//		wardService.save(ward);
//	}
//	
//	@Test
//	public void testfindById() { 
//		System.out.println(wardService.findById(5).getCreateTime());
//	}
//	
//	@Test 
//	public void testfindAll() {
//		List<Ward> wards = wardService.findAll();
//		for(int i=0;i<wards.size();i++) {
//			System.out.println(wards.get(i).getWardId());
//		}
//	}
//	
//	@Test 
//	public void testdelete() {
//		Ward ward = new Ward();
//		ward.setWardId(4);
//		wardService.delete(ward);
//	}
//	
//	@Test 
//	public void testupdate() {
//		Ward ward = new Ward();
//		ward.setWardId(1);
//		Date date = new Date(System.currentTimeMillis());
//		ward.setCreateTime(date);
//		wardService.update(ward);
//	}
	
}
