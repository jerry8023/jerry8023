package com.dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.BaojianVo;
import com.vo.PreorderVo;

public class PreorderDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	
	public PreorderVo getdataById(String id) throws Exception{
		
		String sql="select * from preorder where bjid=? and blsj>sysdate";
		
		return jdbcTemplate.queryDataById(sql, PreorderVo.class, id);
		
	}
	
	
	public Vector<Vector> queryData() throws Exception{
		
		String sql="select poid,poname,phone,decode(sign(blsj-sysdate),1,'Y',-1,'N'),bjtname,preorder.bjid,to_CHAR(ydsj,'yyyy-mm-dd  HH24:MI:SS'),to_CHAR(blsj,'yyyy-mm-dd  HH24:MI:SS'),to_CHAR(podate,'yyyy-mm-dd  HH24:MI:SS'),remarks from preorder,baojian,baojiantype where preorder.bjid=baojian.bjid and baojian.bjtid=baojiantype.bjtid";
		return jdbcTemplate.queryData(sql, null);
		
	}
	
	
	public int deleteDataByPoid(int poid){
		String sql="delete from preorder where poid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, poid);
	}
	
	
	
	public Vector<Vector> queryDataByName(String poname) throws Exception{
		String poname1="%"+poname+"%";
		String sql="select poid,poname,phone,decode(sign(blsj-sysdate),1,'Y',-1,'N'),bjtname,preorder.bjid,to_CHAR(ydsj,'yyyy-mm-dd  HH24:MI:SS'),to_CHAR(blsj,'yyyy-mm-dd  HH24:MI:SS'),to_CHAR(podate,'yyyy-mm-dd  HH24:MI:SS'),remarks from preorder,baojian,baojiantype where preorder.bjid=baojian.bjid and baojian.bjtid=baojiantype.bjtid and (preorder.poname like ? or preorder.bjid like ?)";
		return jdbcTemplate.queryData(sql, new String[]{poname1,poname1});
		
	}
	
	public Vector<Vector> queryByBjid(String bjid) throws Exception{
		
		String sql="select poid,bjid,oid,poname,phone,to_CHAR(podate,'yyyy-mm-dd  HH24:MI:SS'),to_CHAR(ydsj,'yyyy-mm-dd  HH24:MI:SS'),to_CHAR(blsj,'yyyy-mm-dd  HH24:MI:SS'),remarks from preorder where bjid=? and blsj>sysdate";
		
		return jdbcTemplate.queryData(sql, bjid);
		
	}
	
	
	public int updateBlsjByid(String bjid){
		String sql="update preorder set blsj=sysdate where bjid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, bjid);
	}
	
	public int insertData(Object[] values){
		String sql="insert into preorder values(seq_preorder.nextval,?,?,?,?,sysdate,?,?,?)";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}
	
	
	
	public Vector<Vector> queryTableByBjid(String bjid) throws Exception{
		String sql="select * from preorder where bjid=?";
		return jdbcTemplate.queryData(sql, bjid);
	}
	
	
	public int updateData(Object[] values){
		
		String sql="update preorder set bjid=?,oid=?,poname=?,phone=?,ydsj=?,blsj=?,remarks=? where poid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}

	
	public Vector<Vector> queryByYdsj(String ydsjQs,String ydsjZz) throws Exception{
		
		String sql="select poid,poname,phone,decode(sign(blsj-sysdate),1,'Y',-1,'N'),bjtname,preorder.bjid,to_CHAR(ydsj,'yyyy-mm-dd  HH24:MI:SS'),to_CHAR(blsj,'yyyy-mm-dd  HH24:MI:SS'),to_CHAR(podate,'yyyy-mm-dd  HH24:MI:SS'),remarks from preorder,baojian,baojiantype where preorder.bjid=baojian.bjid and baojian.bjtid=baojiantype.bjtid and ydsj>=to_date(?,'yyyy-mm-dd HH24:MI:SS') and ydsj<to_date(?,'yyyy-mm-dd HH24:MI:SS')";
		return jdbcTemplate.queryData(sql, new Object[]{ydsjQs,ydsjZz});
		
	}

}
