package com.dao;

import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.BaojiantypeVo;

public class BaojiantypeDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryDate() throws Exception{
		
		String sql="select bjtname, minxf, jfname,rnrs from baojiantype,jieri,jifei where baojiantype.jrid=jieri.jrid and jieri.jfid=jifei.jfid";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
	
	
	
	public ArrayList<BaojiantypeVo> getAllBaojiantype() throws Exception{
		
		String sql="select * from Baojiantype";
		
		return jdbcTemplate.queryData(sql, BaojiantypeVo.class, null);
	}
	

	public int insertData(Object[] values){
		
		String sql="insert into Baojiantype values(seq_baojiantype.nextval,?,?,?,?,?,?,?)";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		
	}
	
	
	public BaojiantypeVo getVoByBjtname(String bjtName) throws Exception{
		String sql="select * from Baojiantype where bjtname=?";
		return jdbcTemplate.queryDataById(sql, BaojiantypeVo.class, bjtName);
	}
	
	
	public int updateData(Object[] values){
		
		String sql="update Baojiantype set jrid=?,bjtname=?,minxf=?,rnrs=?,jrid1=?,jrid2=?,jridt=? where bjtid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}
	
	
	public int deleteDataByBtyname(String bjtname){
		String sql="delete from Baojiantype where bjtname=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, bjtname);
	}
	

}
