package com.dao;

import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.XiaofeiVo;

public class xiaofeiDao {
	
	public static final int JIESUAN=1;
	public static final int WEIJIESUAN=2;
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public int insertXf(Object[] values){
		String sql="insert into xiaofei(xfid,bjid,oid,rzdate,yajin,state) values(?,?,?,?,?,?)";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}
	
	public XiaofeiVo getXfByBjid(String id) throws Exception{
		String sql="select * from xiaofei where bjid=? and state=2";
		return jdbcTemplate.queryDataById(sql, XiaofeiVo.class, id);
	}
	
	
	public Vector<Vector> queryXfByBjid(String id) throws Exception{
		String sql="select xfid,bjid,oid,to_CHAR(rzdate,'yyyy-mm-dd  HH24:MI:SS'),yajin,state,remarks,cid from xiaofei where bjid=? and state=2";
		return jdbcTemplate.queryData(sql, id);
	}
	
	public int updateState(String xfid,int state){
		String sql="update xiaofei set state=? where xfid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, new Object[]{state,xfid});
	}
	
	
	
	public int updateBjidAndOid(String xfid,String bjid,int oid){
		String sql="update xiaofei set bjid=?,oid=? where xfid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, new Object[]{bjid,oid,xfid});
	}
	
	public int updateYajin(Double yajin,String xfid){
		String sql="update xiaofei set yajin=? where xfid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, new Object[]{yajin,xfid});
	}
	
	
	
}
