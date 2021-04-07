package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.GoodstypeVo;
import com.vo.OperatorVo;

public class OperatorDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryOperator() throws Exception{
		
		String sql="select oid,oname,decode(state,1,'可用',2,'不可以'),qdje from operator";
		return jdbcTemplate.queryData(sql, null);
		
	}
	
	public ArrayList<OperatorVo> getAllOperator() throws Exception{
		
		String sql="select * from operator";
		
		return jdbcTemplate.queryData(sql, OperatorVo.class, null);
	}
	
	
	public OperatorVo getdataById(Integer no) throws Exception{
		
		String sql="select * from operator where oid=?";
		
		return jdbcTemplate.queryDataById(sql, OperatorVo.class, no);
		
	}
	
	public ArrayList<OperatorVo> queryOperatorData() throws Exception{
		
		String sql="select oid,oname,decode(state,1,'可用',2,'不可以'),qdje from operator";
		return jdbcTemplate.queryData(sql,OperatorVo.class, null);
		
	}

}
