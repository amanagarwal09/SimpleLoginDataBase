package com.example.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Register;

@Repository
public class RegisterDaoImpl implements RegisterDao{

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public int insert(Register register) {
		String sql = "insert into register values(?,?,?)";
		int update = jt.update(sql, register.getuserid(), register.getEmail(), register.getPassword());
		return update;
	}

	@Override
	public List<Register> getall() {
		String sql = "select * from register";
		RegisterRowMapper regRowMapper = new RegisterRowMapper();
		return jt.query(sql, regRowMapper);
	}

	@Override
	public Register getByEmail(String email) {
		String sql = "select * from register where email = ?";
		RegisterRowMapper regRowMapper = new RegisterRowMapper();
		Register queryForObject = jt.queryForObject(sql, regRowMapper, email);
		return queryForObject;
	}
}
