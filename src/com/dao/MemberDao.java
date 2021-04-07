package com.dao;

import java.util.ArrayList;
import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.vo.MemberVo;

public class MemberDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryData() throws Exception{
		
		String sql="select mid,mname,sex,cardtype,balance,mgname,jf,sumbalance,birthday,phone,registerdate,decode(state,1,'可用',2,'停用'),remarks from member,mgrade where mgrade.mgid=member.mgid";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
	
	
	public Vector<Vector> queryDataByMgid(int mgid) throws Exception{
		
		String sql="select mid,mname,sex,cardtype,balance,mgname,jf,sumbalance,birthday,phone,registerdate,decode(state,1,'可用',2,'停用'),remarks from member,mgrade where mgrade.mgid=member.mgid and member.mgid=?";
	
		return jdbcTemplate.queryData(sql, mgid);
	
	}
	
	
	
	public MemberVo getMemberVoByHyid(int id) throws Exception{
		
		String sql="select member.*,mgrade.* from member,mgrade where member.mgid=mgrade.mgid and member.mid=? and member.state=1";
		return jdbcTemplate.queryDataById(sql, MemberVo.class, id);
		
	}
	
	public int updateJfAndSb(Double xfje,Integer mid,Double jfbl){
		String sql="update member set jf=jf+?,sumbalance=sumbalance+? where mid=?";
		Object[] values=new Object[]{(int)(xfje/jfbl),xfje,mid};
		return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		
	}
	
	
	public Vector<Vector> qreryAllDataByStrid(String id) throws Exception{
		String sql = "select mid,mname,sex,cardtype,balance,mgname,jf,sumbalance,birthday,phone,registerdate,decode(state,1,'可用',2,'停用'),remarks from member,mgrade where member.mgid=mgrade.mgid and mid like ?" ;
		return jdbcTemplate.queryData(sql, "%"+id+"%");
	}
	
	//根据编号筛选出所需信息
		public Vector<Vector> qreryAllDataById(Integer id) throws Exception{
			String sql = "select mid,mname,sex,cardtype,balance,mgname,jf,sumbalance,birthday,phone,registerdate,decode(state,1,'可用',2,'停用'),remarks from member,mgrade where member.mgid=mgrade.mgid and mid=?" ;
			return jdbcTemplate.queryData(sql, id);
		}
		
		//根据编号筛选出所需信息
		public Vector<Vector> qreryAllDataByName(String name) throws Exception{
			String sql = "select mid,mname,sex,cardtype,balance,mgname,jf,sumbalance,birthday,phone,registerdate,decode(state,1,'可用',2,'停用'),remarks from member,mgrade where member.mgid=mgrade.mgid and mname like ?" ;
			name = "%"+name+"%";
			return jdbcTemplate.queryData(sql, name);
		}
		
		public ArrayList<MemberVo>  queryAllData() throws Exception{   
			String sql = "select mid,mname,sex,cardtype,balance,mgname,jf,sumbalance,birthday,phone,registerdate,decode(state,1,'可用',2,'停用'),remarks from member,mgrade where member.mgid=mgrade.mgid";
			return jdbcTemplate.queryData(sql,MemberVo.class, null);
		}
		
		//根据会员编号得到卡的有效期
		public Object  queryDataById(Integer id,int count) throws Exception{  
			String  sql = "";
			if(count==1){
				sql = "select usedate from member where mid=?";
			}else if(count==2){
				sql = "select password from member where mid=?";
			}
			return jdbcTemplate.queryData(sql, id);
		}
		
		//根据会员编号得到密码
		public boolean queryPwd(String password,Integer id){
			String sql = "update member set password=? where mid=?";
			Object values[] = new Object[]{password,id};
			return jdbcTemplate.insertOrUpdateOrDelete(sql, values)>0?true:false;
		}
		
		
		//删除选中的行
		public boolean deleteData(Integer id){
			String sql = "delete member where mid=?";
			return jdbcTemplate.insertOrUpdateOrDelete(sql, id)>0?true:false;
		}
		
		
		
		public boolean insertData(MemberVo vo){
			if(vo.getPassword()==null){
				vo.setPassword(null);
			}
			//System.out.println(vo.getMid()+"-"+vo.getMgid()+"-"+vo.getSex()+"-"+vo.getCardtype()+"-"+vo.getPassword()+"-"+vo.getUsedate()+"-"+
			//vo.getBalance()+"-"+vo.getJf()+"-"+vo.getSumbalance()+"-"+vo.getBirthday()+"-"+vo.getPhone()+"-"+
			//vo.getRegisterdate()+"-"+vo.getState()+"-"+vo.getRemarks());
			String sql = "insert into member(mid,mgid,mname,sex,cardtype,password,usedate,balance,jf,sumbalance,birthday,phone,registerdate,state,remarks) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Object values[]= new Object[]{vo.getMid(),vo.getMgid(),vo.getMname(),vo.getSex(),vo.getCardtype(),vo.getPassword(),vo.getUsedate(),
					vo.getBalance(),vo.getJf(),vo.getSumbalance(),vo.getBirthday(),vo.getPhone(),
					vo.getRegisterdate(),vo.getState(),vo.getRemarks()};
			return jdbcTemplate.insertOrUpdateOrDelete(sql, values)>0?true:false;
		}
		
		public boolean updateDate(MemberVo vo){
			String sql =  "update member set mgid=?,mname=?,sex=?,cardtype=?,usedate=?,jf=?,birthday=?,phone=?,state=?,remarks=? where mid = ?";
			Object values[] = new Object[]{vo.getMgid(),vo.getMname(),vo.getSex(),vo.getCardtype(),vo.getUsedate(),vo.getJf(),vo.getBirthday(),vo.getPhone(),vo.getState(),vo.getRemarks(),vo.getMid()};
		
			return jdbcTemplate.insertOrUpdateOrDelete(sql, values)>0?true:false;
		}
	
	
	

}
