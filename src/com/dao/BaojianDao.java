package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.BaojianVo;
import com.vo.OperatorVo;
import com.vo.SgradeVo;

public class BaojianDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryDate() throws Exception{
		
		String sql="select bjid,bjtname,decode(state,1,'可用',2,'停用',3,'预定',4,'占用'),area from  baojian ,baojiantype where baojian.bjtid=baojiantype.bjtid";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
	
	
	public ArrayList<BaojianVo> getAllBaojian() throws Exception{
		
		String sql="select * from  baojian ,baojiantype where baojian.bjtid=baojiantype.bjtid";
		
		return jdbcTemplate.queryData(sql, BaojianVo.class, null);
	}
	
	
	public int update(String bjid){
		
		String sql="update baojian set state=4 where bjid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, bjid);
		
	}
	
	public int updateState(String bjid,int state){
		String sql="update baojian set state=? where bjid=?";
		return jdbcTemplate.insertOrUpdateOrDelete(sql, new Object[]{state,bjid});
	}
	
	
	public BaojianVo getBjByBjid(String id) throws Exception{
		String sql="select * from baojian where bjid=? ";
		return jdbcTemplate.queryDataById(sql, BaojianVo.class, id);
	}
	
	
	public ArrayList<BaojianVo> getBjByBjtid(int bjtid) throws Exception{
		String sql="select * from baojian where bjtid=? and state=1";
		return jdbcTemplate.queryData(sql, BaojianVo.class, bjtid);
	}
	
	
	public ArrayList<BaojianVo> getAllBjByBjtid(int bjtid) throws Exception{
		String sql="select * from baojian where bjtid=? ";
		return jdbcTemplate.queryData(sql, BaojianVo.class, bjtid);
	}
	
		//用ArrayList查询得到所有的包间信息
		public ArrayList<BaojianVo> queryData() throws Exception{
			
			String sql="select bjid,bjtname,decode(state,1,'可用',2,'停用',3,'预定',4,'占用'),area from  baojian ,baojiantype where baojian.bjtid=baojiantype.bjtid";
			
			return jdbcTemplate.queryData(sql,BaojianVo.class, null);
		
		}
		
		//由包间类型名字得到包间类型编号
		public Vector<Vector> querryBjtName(String name) throws Exception{
			String sql = "select bjtid from baojiantype where bjtname=?";
			Object values = name;
			return jdbcTemplate.queryData(sql, values);
		}
		
		//插入数据
		public boolean saveBaojian(BaojianVo vo){
			String sql = "insert into baojian(bjid,bjname,bjtid,state,area) values(?,?,?,?,?)";
			Object values[]=null;
			if(vo!=null){
				values = new Object[]{vo.getBjid(),vo.getBjname(),vo.getBjtid(),vo.getState(),vo.getArea()};
			}
			int res = jdbcTemplate.insertOrUpdateOrDelete(sql, values);
			return res>0 ?true:false;
		}
		
		//更新包间中的值
		public boolean updateBaojian(BaojianVo vo){
			String sql = "update baojian set  bjid=?,bjtid=?,area=? where bjname=?";
			System.out.println(vo.getBjname()+"-"+vo.getBjid()+"-"+vo.getBjtid()+"-"+vo.getArea());
			Object values[] = new Object[]{vo.getBjid(),vo.getBjtid(),vo.getArea(),vo.getBjname()};
			int res = jdbcTemplate.insertOrUpdateOrDelete(sql, values);
			if(res>0){
				
				String sql1 = "update baojian set bjname=? where bjid=?";
				Object value[]= new Object[]{vo.getBjid(),vo.getBjid()};
				return jdbcTemplate.insertOrUpdateOrDelete(sql1, value)>0?true:false;
			}
			System.out.println("res:"+res);
			return false;
		}
		
		//通过查询，得到包间表中的对应的列值
		public ArrayList<BaojianVo> getAllBaojian1() throws Exception{
			
			String sql="select bjid,bjtname,state from  baojian ,baojiantype where baojian.bjtid=baojiantype.bjtid";
			
			return jdbcTemplate.queryData(sql, BaojianVo.class, null);
		}

		//根据包间号，删除对应的信息
		public int deleteId(Object id){
			String sql = "delete baojian where bjid=?";
			return jdbcTemplate.insertOrUpdateOrDelete(sql, id);
		}
		
		
		public Vector<Vector> queryDataById(Object id) throws Exception{
			String sql="select bjid,bjtname,decode(state,1,'可用',2,'停用',3,'预定',4,'占用'),area from  baojian ,baojiantype where baojian.bjtid=baojiantype.bjtid and baojian.bjtid=?";
			//System.out.println("sql:"+sql);
			return jdbcTemplate.queryData(sql, id);
		}
		
		public BaojianVo getVoByBjid(String id) throws Exception{
			String sql="select baojian.*,baojiantype.* from baojian,baojiantype where bjid=? and baojian.bjtid=baojiantype.bjtid ";
			return jdbcTemplate.queryDataById(sql, BaojianVo.class, id);
		}

}
