package com.dao;

import java.util.Vector;

import com.jdbc.util.JdbcTemplate;

public class RoleDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryDate() throws Exception{
		
		String sql="select * from role";
	
		return jdbcTemplate.queryData(sql, null);
	
	}

}
