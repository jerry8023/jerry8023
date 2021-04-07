package com.dao;

import com.jdbc.util.JdbcTemplate;

public class JiezhangDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public int insertJz(Object[] values){
		
		String sql="insert into jiezhang values(?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		
	}

}
