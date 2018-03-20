package com.marco.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class AdminRowMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
		Admin admin = new Admin();
		admin.setIdAdmin(rs.getInt("idAdmin"));
		admin.setName(rs.getString("name"));
		admin.setRole(rs.getString("role"));
		admin.setCreationDate(rs.getTimestamp("creationDate"));
		return admin;
	}

}
