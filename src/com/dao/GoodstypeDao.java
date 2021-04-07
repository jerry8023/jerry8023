package com.dao;

import java.util.ArrayList;
import java.util.Vector;
import com.jdbc.util.JdbcTemplate;
import com.vo.BaojiantypeVo;
import com.vo.GoodstypeVo;

public class GoodstypeDao {

	JdbcTemplate jdbcTemplate = new JdbcTemplate();

	public Vector<Vector> queryDate() throws Exception {

		String sql = "select gtid,gtname,decode(isserve,1,'需要',2,'不需要') from goodstype";

		return jdbcTemplate.queryData(sql, null);

	}

	public ArrayList<GoodstypeVo> getAllGoodstype() throws Exception {

		String sql = "select * from goodstype";
		return jdbcTemplate.queryData(sql, GoodstypeVo.class, null);
		
	}

	public GoodstypeVo getGtByGtid(int gtid) throws Exception {
		String sql = "select * from goodstype where gtid=?";
		return jdbcTemplate.queryDataById(sql, GoodstypeVo.class, gtid);
	}

	public boolean deleteGoodstype(GoodstypeVo goodst) {

		String sql = "delete goodstype where gtid=?";

		// 创建Object数组
		Object[] values = new Object[] { goodst.getGtid() };
		// System.out.println("dao-->"+goodst.getGtid());
		int res = jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		// return jdbcTemplate.insertOrUpdateOrDelete(sql, values)
		return res > 0 ? true : false;

	}

	
	
	public boolean saveGoodstype(GoodstypeVo goodst) {

		String sql = "insert into goodstype values(seq_goodstype.nextval,?,?)";
		// 创建Object数组
		Object[] values = new Object[] { goodst.getGtname(),
				goodst.getIsserve() };
		int res = jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		// return jdbcTemplate.insertOrUpdateOrDelete(sql, values)
		return res > 0 ? true : false;
	}

	
	
	public boolean updateGoodstype(GoodstypeVo goodst) {

		String sql = "update goodstype set gtname=?,isserve=? where gtid=?";
		// 创建Object数组
		Object[] values = new Object[] { goodst.getGtname(),
				goodst.getIsserve(), goodst.getGtid() };
		int res = jdbcTemplate.insertOrUpdateOrDelete(sql, values);
		// return jdbcTemplate.insertOrUpdateOrDelete(sql, values)
		return res > 0 ? true : false;
	}
	
	
	public GoodstypeVo getVoByGtname(String gtname) throws Exception{
		String sql="select * from goodstype where gtname=?";
		return jdbcTemplate.queryDataById(sql, GoodstypeVo.class, gtname);
	}

	
	
}
