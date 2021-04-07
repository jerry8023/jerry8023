package com.dao;

import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.XfdetailVo;

public class XfdetailDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public int insertdata(Object[] values){
	
		String sql="insert into xfdetail values(seq_xfdetail.nextval,?,?,?,?,?,?)";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}
	
	public Vector<Vector> queryXfdetailByXfid(String xfid) throws Exception{
		
		String sql="select xfdid,gid,xfid,fwsid,numbers,to_char(xfsj,'yyyy-mm-dd HH24:MI:SS'),oid from xfdetail where xfid=?";
		return jdbcTemplate.queryData(sql, xfid);
		
	}
	
	
}
