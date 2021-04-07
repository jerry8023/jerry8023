package com.dao;

import com.jdbc.util.JdbcTemplate;
import com.vo.GoodsstoreVo;

public class GoodsstoreDao {
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	public boolean updateGsData(GoodsstoreVo vo,int CCKB){
		String sql = "";
		
		if(CCKB==0){
			sql = "update goodsstore set kucun=kucun+? where shid=? and gid=?";
		
		}else if(CCKB==1){
			sql = "update goodsstore set kucun=kucun-? where shid=? and gid=?";
		}
		Object values[] =  new Object[]{vo.getKucun(),vo.getShid(),vo.getGid()};

		return jdbcTemplate.insertOrUpdateOrDelete(sql, values)>0?true:false;
	}
	
	public boolean insertGsData(GoodsstoreVo vo){
		String sql =  "insert into goodsstore(shid,gid,kucun) values(?,?,?)";
		
		Object values[] = new Object[]{vo.getShid(),vo.getGid(),vo.getKucun()};
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values)>0?true:false;
	}
	
}
