package com.dao;

import com.jdbc.util.JdbcTemplate;
import com.vo.HuowuVo;

public class HuowuDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	public boolean insertHw(HuowuVo vo,int CCKB){
		
		String sql = "";
		Object values[] =  null;
		if(CCKB==0){
			sql = "insert into huowu(hid,drsh,sid,oid,yfzk,sfzk,remarks,state,tddate)" +
					" values(?,?,?,?,?,?,?,?,?)";
			
			values = new Object[]{vo.getHid(),vo.getDrsh(),vo.getSid(),vo.getOid(),vo.getYfzk(),
							vo.getSfzk(),vo.getRemarks(),vo.getState(),vo.getTddate()};
		}else if(CCKB==1){
			sql = "insert into huowu(hid,dcsh,sid,oid,yfzk,sfzk,remarks,state,tddate)" +
					" values(?,?,?,?,?,?,?,?,?)";
			
			values = new Object[]{vo.getHid(),vo.getDcsh(),vo.getSid(),vo.getOid(),vo.getYfzk(),
							vo.getSfzk(),vo.getRemarks(),vo.getState(),vo.getTddate()};
		}else if(CCKB==2){
			sql = "insert into huowu(hid,drsh,dcsh,oid,remarks,state,tddate)" +
					" values(?,?,?,?,?,?,?)";
			
			values = new Object[]{vo.getHid(),vo.getDrsh(),vo.getDcsh(),vo.getOid(),vo.getRemarks(),vo.getState(),vo.getTddate()};
	
		}else if(CCKB==3){
			sql = "insert into huowu(hid,dcsh,oid,yfzk,remarks,state,tddate)" +
					" values(?,?,?,?,?,?,?)";
			
			values = new Object[]{vo.getHid(),vo.getDcsh(),vo.getOid(),vo.getYfzk(),vo.getRemarks(),vo.getState(),vo.getTddate()};
	
		}
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values)>0?true:false;
	}
}
