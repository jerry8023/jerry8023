package com.dao;

import com.jdbc.util.JdbcTemplate;
import com.vo.HwdetailVo;

public class HwdetailDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public boolean insertHwdData(HwdetailVo vo){
		
		String sql  = "insert into hwdetail(hwdid,gid,hid,price,numbers)" +
				" values(seq_hwddetail.nextval,?,?,?,?)";
		Object values[]  = new Object[]{vo.getGid(),vo.getHid(),vo.getPrice(),vo.getNumbers()};
			
		
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values)>0?true:false;
	}
}
