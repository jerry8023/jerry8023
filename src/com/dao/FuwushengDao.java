package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.FuwushengVo;

public class FuwushengDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryDate() throws Exception{
		
		String sql="select fwsid,fwsname,fwsjp,fwssex,bjtname,'нч',sgname,fwsphone,fwsidcard from fuwusheng,sgrade,baojiantype where fuwusheng.sgid=sgrade.sgid and fuwusheng.bjtid=baojiantype.bjtid";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
	
	
	public Vector<Vector> queryDateBySgname(String sgname) throws Exception{
		
		String sql="select fwsid,fwsname,fwsjp,fwssex,bjtname,'нч',sgname,fwsphone,fwsidcard from fuwusheng,sgrade,baojiantype where fuwusheng.sgid=sgrade.sgid and fuwusheng.bjtid=baojiantype.bjtid and sgrade.sgname=?";
	
		return jdbcTemplate.queryData(sql, sgname);
	
	}
	
	
	
	public Vector<Vector> queryDate1() throws Exception{
		
		String sql="select fwsid,fwsname,fwssex,fwsidcard,fwsphone,bjtname,sgname from fuwusheng,sgrade,baojiantype where fuwusheng.sgid=sgrade.sgid and fuwusheng.bjtid=baojiantype.bjtid";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
	
	
	
	public Vector<Vector> queryDate2() throws Exception{
		
		String sql="select f.fwsid,f.fwsname,f.fwssex,f.fwsidcard,f.fwsphone,b.bjtname,s.sgname   from sgrade s,fuwusheng f,baojiantype b where f.sgid=s.sgid and f.bjtid=b.bjtid";
	
		return jdbcTemplate.queryData(sql, null);
	
	}

	
	public Vector<Vector> queryDate2ByBjtname(String bjtname) throws Exception{
		
		String sql="select f.fwsid,f.fwsname,f.fwssex,f.fwsidcard,f.fwsphone,b.bjtname,s.sgname   from sgrade s,fuwusheng f,baojiantype b where f.sgid=s.sgid and f.bjtid=b.bjtid and b.bjtname=?";
	
		return jdbcTemplate.queryData(sql, bjtname);
	
	}
	
	
	public Vector<Vector> queryDateSz(FuwushengVo fwsvo) throws Exception{
	
		String sql="select * from (select f.fwsid b,f.fwsname,f.fwssex,f.fwsidcard,f.fwsphone,b.bjtname,s.sgname   from sgrade s,fuwusheng f,baojiantype b where f.sgid=s.sgid and f.bjtid=b.bjtid)m where m.b=?";
    	Object[] values=new Object[]{fwsvo.getFwsid()};
		return   jdbcTemplate.queryData(sql, values);

	}
	
	
	
	public Vector<Vector> queryDateXm(FuwushengVo vo) throws Exception{
	
		String sql="select  * from (select f.fwsid b,f.fwsname n,f.fwssex,f.fwsidcard,f.fwsphone,b.bjtname,s.sgname   from sgrade s,fuwusheng f," +
			"baojiantype b where f.sgid=s.sgid and f.bjtid=b.bjtid)m where m.n like ?";
		// "%"+ghh+"%"
		Object[] values=new Object[]{"%"+vo.getFwsname()+"%"};
		//System.out.println("%"+vo.getFwsname()+"%");
		return jdbcTemplate.queryData(sql, values);

	}
	
	
	
	 public  boolean saveFuwusheng(FuwushengVo fswVo){
		   String sql="insert into Fuwusheng  values(?,?,?,?,?,?,?,?,?);";
		   Object [] values=new Object []{fswVo.getFwsid(),fswVo.getSgid(),fswVo.getBjtid(),fswVo.getFwsname(),fswVo.getFwsjp(),fswVo.getFwssex(), fswVo.getFwsphone(),fswVo.getFwsidcard(),fswVo.getWfsremarks()};
		   int res=jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		   return res>0? true:false;
	}
	 
	 
	public int insertData(Object[] values){
		String sql="insert into fuwusheng values(?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}
	
	
	public ArrayList<FuwushengVo> queryAllData() throws Exception{
		String sql="select * from fuwusheng";
		return jdbcTemplate.queryData(sql, FuwushengVo.class, null);
	}
	
	
	public FuwushengVo getVoByFwsid(Integer fwsid) throws Exception{
		String sql="select * from fuwusheng where fwsid=?";
		return jdbcTemplate.queryDataById(sql, FuwushengVo.class, fwsid);
	}
	
	
	public int updateData(Object[] values){
		String sql="update fuwusheng set sgid=?,bjtid=?,fwsname=?,fwsjp=?,fwssex=?,fwsphone=?,fwsidcard=?,wfsremarks=? where fwsid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
	}
	
	
	public int deleteData(Integer fwsid){
		String sql="delete from fuwusheng where fwsid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, fwsid);
	}
	 
	
}
