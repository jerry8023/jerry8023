package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;

import com.jdbc.util.JdbcTemplate;
import com.vo.SupplierVo;

public class GhsxxDao {

	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	public Vector<Vector> querGhsxx() throws Exception{
		String sql="select sid, sname, sjc ,contact, phone ,address,decode(ismr,1,'Y',2,'N'),remarks  from supplier";
		
		
		
		return jdbcTemplate.queryData(sql, null);
	}
	
	
	public boolean insertGhsxx(SupplierVo vo){
		String  sql="insert into supplier values(?,?,?,?,?,?,?,?) ";
		
		Object[] values=new Object[]{vo.getSid(),vo.getSname(),vo.getSjc(),vo.getContact(),vo.getPhone(),vo.getAddress(),vo.getIsmr(),vo.getRemarks()};
		
		
		int res=jdbcTemplate.insertOrUpdateOrDelete( sql, values);
		return res>0 ? true:false;
		
		
	}
	public boolean upadateGhsxx(SupplierVo vo){
		String sql="update supplier set  sname=?, sjc=?, contact=?, phone=?, address=?, ismr=? ,remarks=? where sid=?";
		Object[] values=new Object[]{vo.getSname(),vo.getSjc(),vo.getContact(),vo.getPhone(),vo.getAddress(),vo.getIsmr(),vo.getRemarks(),vo.getSid()};


		int res=jdbcTemplate.insertOrUpdateOrDelete( sql, values);
		return res>0 ? true:false;
		
	}
	
	public boolean deleteGhsxx(SupplierVo vo){
		
		String sql="delete supplier where sid=?";
		
		Object[] values=new Object[]{vo.getSid()};

	int	res=jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		
		return res>0 ? true:false;
	}
	
	
	public Vector<Vector> querGhsxxsz(SupplierVo vo) throws Exception{
		String sql="select *from (select sid, sname, sjc ,contact, phone ,address,decode(ismr,1,'Y',2,'N'),remarks  from supplier)m where m.sid=?";
		
		Object [] values= new Object[]{vo.getSid()};
		//System.out.println("dao"+vo);
		return jdbcTemplate.queryData(sql, values);
	}
	
	public Vector<Vector> querGhsxxjp(SupplierVo vo) throws Exception{
		String sql="select *from (select sid, sname, sjc ,contact, phone ,address,decode(ismr,1,'Y',2,'N'),remarks  from supplier)m  where m.sjc like ?";
		
		Object [] values= new Object[]{"%"+vo.getSjc()+"%"};
		
		return jdbcTemplate.queryData(sql, values);
	}
	
	
}
