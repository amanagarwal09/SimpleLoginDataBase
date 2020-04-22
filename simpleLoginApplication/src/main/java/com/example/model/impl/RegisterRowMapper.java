package com.example.model.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Register;

public class RegisterRowMapper implements RowMapper<Register> {
	@Override
	public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
		Register register = new Register();
		register.setuserid(rs.getString(1));
		register.setEmail(rs.getString(2));
		register.setPassword(rs.getString(3));
		return register;
	}
}
