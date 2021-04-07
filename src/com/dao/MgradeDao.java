package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.MgradeVo;

public class MgradeDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryDate() throws Exception{
		
		String sql="select * from mgrade";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
	
	public MgradeVo queryMgMinid() throws Exception{
		String sql="select min(mgid) from mgrade";
		return jdbcTemplate.queryDataById(sql, MgradeVo.class, null);
	}
	
	
	public boolean insertMgradeAll(MgradeVo vo){
		String sql = "insert into mgrade values(seq_mgrade.nextval,?,?,?,?)";
		Object[] values = new Object[] {vo.getMgname(),vo.getCsjf(),vo.getRebate(),vo.getUsenumber()};
		int res = jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		return res > 0 ? true : false;
	}

	
	
	public boolean updateMgradeAll(MgradeVo vo){
		String sql = "update mgrade set mgname=?,csjf=?,rebate=?, usenumber=? where mgid=?";
		Object[] values = new Object[] { vo.getMgname(),vo.getCsjf(),vo.getRebate(),vo.getUsenumber(),vo.getMgid()};
		int res = jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		return res > 0 ? true : false;
	} 

	
	public boolean deleteMgrdae(MgradeVo vo){
		String sql="delete Mgrade where mgid=?";
		Object[] values=new Object[]{vo.getMgid()};
		int res=jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		return res>0 ? true : false;
	}
	
	
	public ArrayList<MgradeVo> queryData() throws Exception{
		String sql = "select * from mgrade";
		return jdbcTemplate.queryData(sql, MgradeVo.class,null);
	}

	
	public MgradeVo getVoByMgname(String mgname) throws Exception{
		String sql="select * from Mgrade where mgname=?";
		return jdbcTemplate.queryDataById(sql, MgradeVo.class, mgname);
	}
	
	public MgradeVo getVoByMgid(Integer mgid) throws Exception{
		String sql="select * from Mgrade where mgid=?";
		return jdbcTemplate.queryDataById(sql, MgradeVo.class, mgid);
	}
	
}
