package com.niit.service;

import java.util.List;

import com.niit.model.Department;

public interface IDepartmentService {
	public void saveDepartment(Department department);
    public Department findDepartmentById(Integer departmentId);
    public List<Department> findAll();
    public void deleteDepartmentById(Integer departmentId);
    public void deleteDepartment(Department department);
    public void updateDepartment(Department department);
    
}
