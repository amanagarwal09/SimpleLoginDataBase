package com.example.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.RegisterCompany;

@Repository
public class RegisterCompanyDaoImpl implements RegisterCompanyDao {

	@Autowired
	JdbcTemplate jt;

	@Override
	public int insert(RegisterCompany rc) {
		String sql = "insert into registercompany values(?,?,?,?,?,?,?,?)";
		int update = jt.update(sql, null , rc.getName(), rc.getCompanyname(), rc.getContact(), rc.getGender(), rc.getCountry(),
				rc.getState(), rc.getCity());
		return update;
	}

	@Override
	public List<RegisterCompany> getall() {
		String sql = "select * from registercompany";
		RegRowMapper rowMapper = new RegRowMapper();
		return jt.query(sql, rowMapper);
	}

	@Override
	public int update(RegisterCompany rc) {
		String sql = "update registercompany set name=?, companyname=?, contact=?, gender=?, country=?, state=?, city=? where id=?";
		System.out.println(rc);
		int update = jt.update(sql, rc.getName(), rc.getCompanyname(), rc.getContact(), rc.getGender(), rc.getCountry(),
				rc.getState(), rc.getCity(), rc.getId());
		return update;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from registercompany where id=?";
		int update = jt.update(sql, id);
		return update;
	}

}
