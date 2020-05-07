package com.example.model.impl;

import java.util.List;

import com.example.model.RegisterCompany;

public interface RegisterCompanyDao {
	int insert(RegisterCompany rc);
	List<RegisterCompany> getall();
	int update(RegisterCompany rc);
	int delete(int id);
}
