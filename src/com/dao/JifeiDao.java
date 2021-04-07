package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.JifeiVo;

public class JifeiDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryDate() throws Exception{
		
		String sql="select jfname,jfdw,jfsjp,ksjf,decode(bzjf,1,'按计费单位',2,'按时间片') from jifei";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
	
	public JifeiVo getJfByBjtid(int id) throws Exception{
		
		String sql="select jifei.* from jifei,jieri,baojiantype  where baojiantype.bjtid=? and jifei.jfid=jieri.jfid and baojiantype.jrid=jieri.jrid";
		return jdbcTemplate.queryDataById(sql, JifeiVo.class, id);
		
	}
	
	public ArrayList<JifeiVo> queryAllDatas() throws Exception{
		
		String sql="select * from jifei";
		return jdbcTemplate.queryData(sql, JifeiVo.class, null);
		
	}
	
	
	public JifeiVo getVoByJfid(int jfid) throws Exception{
		
		String sql="select * from jifei where jfid=?";
		return jdbcTemplate.queryDataById(sql, JifeiVo.class, jfid);
		
	}

	
	
	
}
