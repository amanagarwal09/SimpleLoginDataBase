package com.example.model.impl;

import java.util.List;

import com.example.model.Register;

public interface RegisterDao {
	int insert(Register register);
	List<Register> getall();
	Register getByEmail(String email);
}
