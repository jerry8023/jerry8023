package com.dao;

import java.util.Vector;

import com.jdbc.util.JdbcTemplate;
import com.util.YanZhengUtil;
import com.vo.GoodsVo;

public class GoodsDao {
	
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Vector<Vector> queryDate() throws Exception{
		
		String sql="select gid,dname,dw,price,costs,gtname,stock,decode(isjskc,1,'Y',2,'N'),warnstock,decode(isdh,1,'Y',2,'N'),dhjf from goodstype,goods where goods.gtid=goodstype.gtid";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
	
	public Vector<Vector> queryDate1() throws Exception{
		
		String sql="select gid,dname,price,stock from goods";
	
		return jdbcTemplate.queryData(sql, null);
	
	}
	
	public Vector<Vector> queryDateByJcOrBh(String text) throws Exception{
		
		String sql="";
		if(YanZhengUtil.isShuZi(text)){
			 sql="select gid,dname,price,stock from goods where goods.gid like ?";
			 return jdbcTemplate.queryData(sql, ("%"+text+"%"));
		}else{
			
			if(text.length()==0||text==null){
				text="";
			}
			 text=text.toLowerCase();
			 sql="select gid,dname,price,stock from goods where  goods.jp like ?";
			 return jdbcTemplate.queryData(sql, ("%"+text+"%"));
		}
		
	
	}
	
	
	/*public Vector<Vector> queryDateByJcOrBh1(String text) throws Exception{
		
		String sql="";
		if(YanZhengUtil.isShuZi(text)){
			 sql="select gid,dname,dw,price,costs,gtname,stock,decode(isjskc,1,'Y',2,'N'),warnstock,decode(isdh,1,'Y',2,'N'),dhjf from goodstype,goods where goods.gtid=goodstype.gtid and goods.gid=?";
			 return jdbcTemplate.queryData(sql, Integer.parseInt(text));
		}else{
			
			if(text.length()==0||text==null){
				text="";
			}
			 text=text.toLowerCase();
			 sql="select gid,dname,dw,price,costs,gtname,stock,decode(isjskc,1,'Y',2,'N'),warnstock,decode(isdh,1,'Y',2,'N'),dhjf from goodstype,goods where goods.gtid=goodstype.gtid and goods.jp like ?";
			 return jdbcTemplate.queryData(sql, ("%"+text+"%"));
		}
		
	
	}*/
	
	public Vector<Vector> queryDateByJcOrBh1(String text) throws Exception{
		
		String sql="";
		if(YanZhengUtil.isShuZi(text)){
			 sql="select gid,dname,dw,price,costs,gtname,stock,decode(isjskc,1,'Y',2,'N'),warnstock,decode(isdh,1,'Y',2,'N'),dhjf from goodstype,goods where goods.gtid=goodstype.gtid and goods.gid like ?";
			 return jdbcTemplate.queryData(sql, ("%"+text+"%"));
		}else{
			
			if(text.length()==0||text==null){
				text="";
			}
			 text=text.toLowerCase();
			 sql="select gid,dname,dw,price,costs,gtname,stock,decode(isjskc,1,'Y',2,'N'),warnstock,decode(isdh,1,'Y',2,'N'),dhjf from goodstype,goods where goods.gtid=goodstype.gtid and goods.jp like ?";
			 return jdbcTemplate.queryData(sql, ("%"+text+"%"));
		}
		
	
	}
	
	
	
	
	public GoodsVo getDoodsByGid(int gid) throws Exception{
		String sql="select * from goods where gid=?";
		return jdbcTemplate.queryDataById(sql, GoodsVo.class, gid);
	}
	
	
	//查询所有的商品信息，此查询用于商品采购表ZjspCgjhDialog
		public Vector<Vector> queryDataSp(Integer id,int CCKB) throws Exception{
			if(CCKB==0){
				String sql="select gid,dname,costs,stock from goods,goodstype where goods.gtid=goodstype.gtid and goodstype.gtname='商品类'";
			
				//System.out.println("sql:"+sql);
				return jdbcTemplate.queryData(sql, null);
			}else {
				String sql="select goods.gid,dname,costs,kucun from goods,goodstype,goodsstore where goods.gtid=goodstype.gtid and goodstype.gtname='商品类' and  goodsstore.gid=goods.gid and goodsstore.shid=?";
				
				//System.out.println("sql:"+sql);
				return jdbcTemplate.queryData(sql, id);
			}
		
		}
		
		//通过商品编号得到商品信息，此查询用于商品采购表ZjspCgjhDialog
		public Vector<Vector> queryDataSpById(String id,Integer ckId,int CCKB) throws Exception{
			if(CCKB==0){
				String sql="select gid,dname,costs,stock from goods,goodstype where goods.gtid=goodstype.gtid and goodstype.gtname='商品类' and gid like ? ";
				
				//System.out.println("sql:"+sql);
				return jdbcTemplate.queryData(sql, "%"+id+"%");
			}else{
				String sql="select goods.gid,dname,costs,kucun from goods,goodstype,goodsstore where goods.gtid=goodstype.gtid and goodstype.gtname='商品类' and goods.gid like ?  and goodsstore.gid=goods.gid and goodsstore.shid=?";
				Object values[] = new Object[]{"%"+id+"%",ckId};
				//System.out.println("sql:"+sql);
				return jdbcTemplate.queryData(sql, values);
			}
		
		}
		
		//通过商品名简称得到商品信息，此查询用于商品采购表ZjspCgjhDialog
		public Vector<Vector> queryDataSpByName(String name,Integer ckId,int CCKB) throws Exception{
			if(CCKB==0){
				String sql="select goods.gid,dname,costs,stock from goods,goodstype where goods.gtid=goodstype.gtid and goodstype.gtname='商品类' and jp like  ? ";
				name = "%"+name+"%";
				
			//	System.out.println("sql:"+sql);
				return jdbcTemplate.queryData(sql, name);
			}else{
				String sql="select goods.gid,dname,costs,kucun from goods,goodstype,goodsstore where goods.gtid=goodstype.gtid and goodstype.gtname='商品类' and jp like  ?  and goodsstore.gid=goods.gid and goodsstore.shid=?";
				name = "%"+name+"%";
				Object values[] = new Object[]{name,ckId};
			//	System.out.println("sql:"+sql);
				return jdbcTemplate.queryData(sql, values);
			}
		
		}
		
		public boolean updateDataById(Integer id,Integer stock,int CCKB){
			String sql = "";
			if(CCKB==0){
				sql = "update goods set  stock=stock+? where gid=? ";
			}else if(CCKB==1){
				sql = "update goods set  stock=stock-? where gid=? ";
			}
			Object values[] = new Object[]{stock,id};
			return jdbcTemplate.insertOrUpdateOrDelete(sql, values)>0?false:true;
		}
		
		
		public Vector<Vector> getDatasByGtid(Integer gtid) throws Exception{
			
			String sql="select gid,dname,dw,price,costs,gtname,stock,decode(isjskc,1,'Y',2,'N'),warnstock,decode(isdh,1,'Y',2,'N'),dhjf from goodstype,goods where goods.gtid=goodstype.gtid and goods.gtid=?";
			return jdbcTemplate.queryData(sql, gtid);
		}
		
		public int insertData(Object[] values){
			String sql="insert into goods values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		}
		
		public int deleteDataByGid(Integer gid){
			String sql="delete from goods where gid=?";
			return jdbcTemplate.insertOrUpdateOrDelete(sql, gid);
		}
		
		
		public int updateDataByGid(Object[] values){
			String sql="update goods set gtid=?,oid=?,dname=?,jp=?,dw=?,price=?,costs=?,stock=?,isjskc=?,warnstock=?,isdh=?,dhjf=?,jfid=? where gid=?";
			return jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		}
		
		public GoodsVo getVoByGname(String gname) throws Exception{
			String sql="select * from goods where dname=?";
			return jdbcTemplate.queryDataById(sql, GoodsVo.class, gname);
		}
		
}
