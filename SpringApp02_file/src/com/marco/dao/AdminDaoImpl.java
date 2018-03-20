package com.marco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marco.pojo.Admin;
import com.marco.pojo.AdminRowMapper;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {

	private JdbcOperations jdbcTemplate;
	
	@Autowired
	public AdminDaoImpl(JdbcOperations jdbcTemplate) {		
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public boolean save(Admin admin) {
		// MapSqlParameterSource paramMap = new MapSqlParameterSource();
		// paramMap.addValue("name", admin.getName());
		// paramMap.addValue("role", admin.getRole());
		// paramMap.addValue("creationDate", admin.getCreationDate());

//		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);

		return jdbcTemplate.update("insert into Admin (name, role, creationDate) values (?, ?, ?) ",
				admin.getName(), admin.getRole(), admin.getCreationDate()) == 1;
	}

	@Override
	public List<Admin> findAll() {
		return jdbcTemplate.query("SELECT * FROM ADMIN", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
				Admin admin = new Admin();
				admin.setIdAdmin(rs.getInt("idAdmin"));
				admin.setName(rs.getString("name"));
				admin.setRole(rs.getString("role"));
				admin.setCreationDate(rs.getTimestamp("creationDate"));
				return admin;
			}

		});
	}

	@Override
	public Admin findById(int id) {
//		return (Admin) jdbcTemplate.query("SELECT * FROM ADMIN WHERE idAdmin = :idAdmin",
//				new MapSqlParameterSource("idAdmin", id), new AdminRowMapper());		
		return jdbcTemplate.queryForObject("SELECT * FROM ADMIN WHERE idAdmin = ?", new AdminRowMapper() , id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findByName(String name) {
		// TODO Auto-generated method stub
		return (List<Admin>) jdbcTemplate.queryForObject("SELECT * FROM ADMIN WHERE name like ?", new AdminRowMapper(), '%' + name + '%');
	}

	@Override
	public boolean update(Admin admin) {
		return jdbcTemplate.update("update Admin set name=?, role=?, creationDate=? where idAdmin= ?",admin.getName(), admin.getRole(), admin.getCreationDate(), admin.getIdAdmin()) == 1;
//		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from ADMIN where idAdmin = ?", id) == 1;
	}

	@Transactional
	@Override
	public int[] saveAll(List<Admin> admins) {
		
//		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(admins.toArray());
		
//		return jdbcTemplate.batchUpdate("insert into Admin (name, role, creationDate) values(:name, :role, :creationDate)", batchArgs);
//		return jdbcTemplate.batchUpdate("insert into Admin (idAdmin, name, role, creationDate) values(:idAdmin, :name, :role, :creationDate)", batchArgs);
		return jdbcTemplate.batchUpdate("insert into Admin (idAdmin, name, role, creationDate) values(:idAdmin, :name, :role, :creationDate)", new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Admin admin = admins.get(i);
				ps.setInt(1, admin.getIdAdmin());
				ps.setString(2, admin.getName());
				ps.setString(3, admin.getRole());
				ps.setTimestamp(4, admin.getCreationDate());				
			}
			
			@Override
			public int getBatchSize() {
				
				return admins.size();
			}
		});
		
	}

}
