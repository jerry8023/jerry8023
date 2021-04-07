package com.dao;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.jdbc.util.JdbcTemplate;
import com.vo.JieriVo;

public class JieriDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	
	public ArrayList<JieriVo> getVoByJfidAndJrname(Integer jfid,String jrname) throws Exception{
		
		String sql="select * from jieri where jfid=? and jrname=?";
		return jdbcTemplate.queryData(sql, JieriVo.class, new Object[]{jfid,jrname});
	
	}
	
	
	
	public int insertData(Object[] values){
		
		String sql="insert into jieri values(seq_jieri.nextval,?,?,?)";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		
	}
	
	
	public JieriVo getVoByJrid(Integer jrid) throws Exception{
		String sql="select jieri.*,jifei.* from jieri,jifei where jieri.jrid=? and jieri.jfid=jifei.jfid";
		return jdbcTemplate.queryDataById(sql, JieriVo.class, jrid);
	}

	
}
