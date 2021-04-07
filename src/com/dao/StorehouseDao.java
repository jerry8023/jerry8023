package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.StorehouseVo;

public class StorehouseDao {
	
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	
	public Vector<Vector> queryStoreData() throws Exception{
		String sql = "select * from storehouse";
		return jdbcTemplate.queryData(sql, null);
	}
	
	
	public ArrayList<StorehouseVo> queryData() throws Exception{
		String sql = "select * from storehouse";
		return jdbcTemplate.queryData(sql,StorehouseVo.class, null);
	}
	
	
	
	public boolean addStorehouse(StorehouseVo storehouse){
		String sql= "insert into storehouse values(?,?)";
		Object [] values=new Object[]{storehouse.getShid(),storehouse.getShname()};
		int res=jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		return res>0? true:false;
	}
	
	
	
	public boolean updateStorehouse(StorehouseVo storehouse){
		String sql="update storehouse set shname=? where shid =?";
		Object []values=new Object[]{storehouse.getShname(),storehouse.getShid()};
		int res=jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		return res>0? true:false;
	}
	
	
	
	public boolean deleteStorehouse(StorehouseVo storehouse){
		String sql="delete storehouse where shid=?";
	    Object [] values=new Object[]{storehouse.getShid()};
	    int res=jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		return res>0?true:false;
	}
	
	
	
	public ArrayList<StorehouseVo> getAllStorehouse() throws Exception{
		String sql="select * from storehouse";
	 	return jdbcTemplate.queryData(sql, StorehouseVo.class, null);
	}
	
	
}
