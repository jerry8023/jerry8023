package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.GoodstypeVo;
import com.vo.SgradeVo;

public class SgradeDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryDate() throws Exception{
		
		String sql="select * from sgrade";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
	
	public ArrayList<SgradeVo> getAllSgrade() throws Exception{
		
		String sql="select * from sgrade";
		
		return jdbcTemplate.queryData(sql, SgradeVo.class, null);
	}
	
	
	
	public boolean saveSgrade(SgradeVo  sgrade){
		
		String sql="insert into  Sgrade values(?,?)";
		
		Object [] values=new Object []{sgrade.getSgid(),sgrade.getSgname()};
		
		int res=jdbcTemplate.insertOrUpdateOrDelete(sql,values);
		
		
		return res>0? true:false;
		
	}
	
	
	
	public boolean updateSgrade(SgradeVo  sgrade){
		
		String sql="update sgrade set sgname=? where sgid=?";
		
		Object[] values=new Object[]{sgrade.getSgname(),sgrade.getSgid()};
		
		int res=jdbcTemplate.insertOrUpdateOrDelete(sql,values);
		
		return res>0? true:false;
		 
	}
	
	
	
    public boolean deleteSgrade(SgradeVo sgradeVo){
    	String sql="delete sgrade where sgid=?";
    	Object values[]=new Object[]{sgradeVo.getSgid()};
    	
    	int res=jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		return res > 0 ? true:false;
	}
	
    
    
    public Vector<Vector> querySgrade() throws Exception{
		
		String sql="select * from sgrade";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
    
    
    public SgradeVo getVoBySgname(String sgname) throws Exception{
    	String sql="select * from sgrade where sgname=?";
    	return jdbcTemplate.queryDataById(sql, SgradeVo.class, sgname);
    }
    
    
    

}
