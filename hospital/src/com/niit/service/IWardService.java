package com.niit.service;

import java.util.List;

import com.niit.model.Ward;

public interface IWardService {
	public List<Ward> findAll();
	public void deleteById(int wardId);
}
