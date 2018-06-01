package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IDepartmentDao;
import com.niit.dao.IDoctorDao;
import com.niit.model.Department;
import com.niit.model.Doctor;
import com.niit.service.IDepartmentService;
import com.niit.service.IDoctorService;
import com.niit.util.MD5keyBean;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
	
	@Resource
	private IDepartmentDao departmentDao;

	@Override
	public void saveDepartment(Department department) {
		this.departmentDao.save(department);
	}

	@Override
	public Department findDepartmentById(Integer departmentId) {
		return  this.departmentDao.findById(departmentId);
	}

	@Override
	public List<Department> findAll() {
		return this.departmentDao.findAll();
	}

	@Override
	public void deleteDepartmentById(Integer departmentId) {
		 this.departmentDao.delete(new Department(departmentId));
	}

	@Override
	public void deleteDepartment(Department department) {
		this.departmentDao.delete(department);
	}

	@Override
	public void updateDepartment(Department department) {
	this.departmentDao.update(department);
		
	}

}
