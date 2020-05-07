package com.example.model.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.RegisterCompany;

public class RegRowMapper implements RowMapper<RegisterCompany>{

	@Override
	public RegisterCompany mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegisterCompany rc = new RegisterCompany();
		rc.setId(rs.getInt(1));
		rc.setName(rs.getString(2));
		rc.setCompanyname(rs.getString(3));
		rc.setContact(rs.getLong(4));
		rc.setGender(rs.getString(5));
		rc.setCountry(rs.getString(6));
		rc.setState(rs.getString(7));
		rc.setCity(rs.getString(8));
		return rc;
	}

}
