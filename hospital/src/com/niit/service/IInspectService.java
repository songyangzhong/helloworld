package com.niit.service;

import java.util.List;

import com.niit.model.Inspect;

public interface IInspectService {
	public List<Inspect> findAll();
	public Inspect findById(int inspectId);
	public void deleteById(int inspectId);
}
