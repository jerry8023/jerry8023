package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.DazheVo;

public class DazheDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	
	public DazheVo getDazhe(Object[] val) throws Exception{
		
		String sql="select * from dazhe where dzname=? and mgid=?";
		
		return jdbcTemplate.queryDataById(sql, DazheVo.class, val);
		
	}
	
	
	public ArrayList<DazheVo> queryByDzname(String Dzname) throws Exception{
		String sql="select * from dazhe where dzname=?";
		return jdbcTemplate.queryData(sql, DazheVo.class, Dzname);
	}
	
	
	public ArrayList<DazheVo> getVoByDznameAndMgname(String dzname,int mgid) throws Exception{
		String sql="select * from dazhe where dzname=? and mgid=?";
		return jdbcTemplate.queryData(sql, DazheVo.class, new Object[]{dzname,mgid});
	}
	
	
	public int insertData(Object[] values){
		String sql="insert into dazhe values(?,?,?,?)";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}
	
	public int updateData(Object[] values){
		String sql="update dazhe set dzbl=?,dzremarks=? where dzname=? and mgid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}
	
	public int deleteData(String dzname,int mgid){
		String sql="delete from dazhe where dzname=? and mgid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, new Object[]{dzname,mgid});
	}
	
	
	
}
