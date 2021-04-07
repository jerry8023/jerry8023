package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import oracle.jdbc.driver.DBConversion;

import com.jdbc.util.JdbcTemplate;
import com.vo.TichengVo;

public class TichengDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryDataByGid(Integer gid) throws Exception{
		String sql="select sgname,ld,dd from sgrade,ticheng where ticheng.sgid=sgrade.sgid and gid=?";
		return jdbcTemplate.queryData(sql, gid);
	}
	
	public ArrayList<TichengVo> getVoByGidAndSgid(Integer gid,Integer sgid) throws Exception{
		String sql="select * from ticheng where gid=? and sgid=?";
		return jdbcTemplate.queryData(sql, TichengVo.class, new Object[]{gid,sgid});
	}
	
	
	public int insertData(Object[] values){
		String sql="insert into ticheng values(?,?,?,?)";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}
	
	
	
	public int updateData(Object[] values){
		String sql="update ticheng set ld=?,dd=? where gid=? and sgid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}
	
	
	
	public int deleteDataByGidAndSgid(Integer gid,Integer sgid){
		String sql="delete from ticheng where gid=? and sgid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, new Object[]{gid,sgid});
	}

}
