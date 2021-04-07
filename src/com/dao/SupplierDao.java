package com.dao;

import java.util.Vector;

import com.jdbc.util.JdbcTemplate;

public class SupplierDao {
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> querysupplierData() throws Exception{
		
		String sql="select sid,sname,phone,address,remarks from supplier";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
}
