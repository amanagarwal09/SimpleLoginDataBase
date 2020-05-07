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
		int update = jt.update(sql, register.getName(), register.getEmail(), register.getPassword());
		return update;
	}

	@Override
	public int update(Register register) {
		String sql = "update register set name=?, password=? where email=? ";
		int update = jt.update(sql, register.getName(), register.getPassword(), register.getEmail());
		return update;
	}

	@Override
	public int delete(String email) {
		String sql = "delete from register where email=?";
		int update = jt.update(sql, email);
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
