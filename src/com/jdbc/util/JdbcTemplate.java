package com.jdbc.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import oracle.sql.BLOB;




public class JdbcTemplate {


	/**
	 * @param sql
	 *            要执行sql语句
	 * @param values
	 *            注入到sql语句中的值
	 * @return  1表示操作成功，2表示操作失败
	 */
	public int insertOrUpdateOrDelete(String sql, Object... values) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//conn = JdbcUtil.getConnection();
			conn=JdbcUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			if (values != null) { // 判断参数values是否为空
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);

		}
		return 0;
	}

	
	/**
	 * 用该方法，设计的Vo类的属性必需和数据库的列名称保持一致.
	 * @param sql
	 * @param cls
	 * @param values
	 * @return 一个VO对象就是一条数据。。。把所有的对象都放在一个集合中。。。。
	 * @throws Exception


 select * from emp 
EmpVO
select * from dept

Result rs

while(rs.next){
  EmpVo vo = new EmpVo();
 vo.setEmpno(rs.getInt("empno"))

}
DetpVo

 
	 */
	public <T> ArrayList<T> queryData(String sql, Class<T> cls,
			Object... values) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<T> dataList = new ArrayList<T>();
		try {
			//conn = JdbcUtil.getConnection();
			conn=JdbcUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			if (values != null) {
				for (int i = 0; i < values.length; i++) { // 长度为1
					pstmt.setObject(i + 1, values[i]);
				}
			}

			res = pstmt.executeQuery();
			ResultSetMetaData metaData = res.getMetaData();
			while (res.next()) {
				// 将数据保存到HashMap中
				HashMap<String, Object> rowValues = new HashMap<String, Object>();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					rowValues.put(metaData.getColumnName(i + 1).toLowerCase(),
							res.getObject(metaData.getColumnName(i + 1)));
				}
				
				T t = setValueToVo(rowValues, cls);//反射,将数据封装到VO类中
				
				dataList.add(t);//添加对象到集合中

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}

		return dataList;
	}

	
	
	
	//Emp.class
	private  <T> T setValueToVo(Map<String, Object> values, Class<T> cls)
			throws Exception {
		
		T obj = cls.newInstance();

		// 得到类的所有方法
		Method[] methods = cls.getMethods();
		
		for (Method m : methods) {

			// 判断是否是set方法
			String mthodName = m.getName();
			if (mthodName.startsWith("set")) {
				// 得到set方法的后半断,如setEmpno 取出empno,再从map中通过empno取出对应的值
				String mName = mthodName.substring(3).toLowerCase();

				// 判断方法的参数类型及个数
				Class[] paramTyps = m.getParameterTypes();
				if (paramTyps != null && paramTyps.length == 1) {
					Object mapValues = values.get(mName);

					// 取出第一个参数类型
					Class types = paramTyps[0];
					String typeName = types.getName();
					
					
					if (mapValues != null) {
						if (typeName.equals("java.lang.String")) {
							if (mapValues instanceof String) {
								m.invoke(obj, mapValues.toString());
							}
						} else if (typeName.equals("int")
								|| typeName.equals("java.lang.Integer")) {
							// 判断mapValues是否能转换成int类型
							if (mapValues.toString().matches("[-]?[0-9]+")) {
								m.invoke(obj,
										Integer.parseInt(mapValues.toString()));
							}
						} else if (typeName.equals("double")
								|| typeName.equals("java.lang.Double")) {
							if (mapValues.toString()
									.matches("[-]?[0-9]+[.]?[0-9]*")) {
								m.invoke(obj, Double.parseDouble(mapValues
										.toString()));
							}
						} else if (typeName.equals("java.sql.Date")) {
							
							if (mapValues instanceof java.sql.Date) {
								// Object 怎么转换成java.sql.Date类型
								m.invoke(obj, (java.sql.Date) mapValues);
							}
							
						}else if(typeName.equals("java.sql.Timestamp")){
							
							if (mapValues instanceof java.sql.Timestamp) {
						
								m.invoke(obj, (java.sql.Timestamp) mapValues);
							}
							if (mapValues instanceof java.sql.Date) {
								//m.invoke(obj,(java.sql.Date)mapValues);
								m.invoke(obj, new java.sql.Timestamp(((java.sql.Date) mapValues).getTime()));
							}
							
						}else if (typeName.equals("[B")){//判断方法的参数是否是byte[]数组
							//取出Blob数据
							if (mapValues instanceof oracle.sql.BLOB){
								//通过IO流，将Blob类型数据读取并赋给byte[]类型的方法setPhoto(byte[] b)
								BLOB blob = (BLOB) mapValues;
								// 获得输出流,用于将磁盘上的文件，写入到该输出流
								InputStream intInputStream = blob.getBinaryStream();

								ByteArrayOutputStream out = new ByteArrayOutputStream();

								// IO流中，将输入流的内容写入到字节数组
								byte[] buf = new byte[1024];
								int len = 0;
								while ((len = intInputStream.read(buf)) != -1) {
									out.write(buf, 0, len);
								}
								
								m.invoke(obj, out.toByteArray());
								
								intInputStream.close();
								out.close();
							}
							
						}
					}
					
					//所有的VO类放到一个包中,以下代码处理如EmpVO中包含DeptVo的情况
					if (typeName.startsWith("com.vo.")){ //typename "com.vo.DeptVo"
						 //如何将查询结果存储到DeptVo中
						 //即然要将值写入DeptVo中，是否需要实例化一个DeptVo类
						 Class innerCls = Class.forName(typeName);
						
						 //再调用一次setValueToVo
						 Object vl = setValueToVo(values, innerCls);
						 
						 //最终要将实例化好的类，set到EmpVo中的setDept(com.vo.DetpVo)
						 m.invoke(obj, vl);
						
					}

				}

			}

		}

		return obj;

	}

	
	//查询方法，返回的是Vector类型数据，用于将数据显示在JTable中
	public Vector<Vector> queryData(String sql,
			Object... values) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Vector<Vector>  dataList = new Vector<Vector>();
		try {
			//conn = JdbcUtil.getConnection();
			conn=JdbcUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			if (values != null) {
				for (int i = 0; i < values.length; i++) { // 长度为1
					pstmt.setObject(i + 1, values[i]);
				}
			}

			res = pstmt.executeQuery();
			ResultSetMetaData metaData = res.getMetaData();
			while (res.next()) {
				
				Vector<Object> rowData = new Vector<Object>();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					rowData.add(res.getObject(metaData.getColumnName(i+1)));
				}

				dataList.add(rowData);// 添加对象到集合中
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}

		return dataList;
	}
	
	
	
	/**
	 * 定义一个通用的查询方法,接收所有的查询语，返回对应的集合
	 * 
	 * queryData方法是一个泛型方法，该方法的返回值，是根据传入的RowMapper的实际类型，决定queryDate方法的返回类型
	 * 
	 * 
	 * @param sql
	 *            传入查询语句
	 * @param 传入实现了RowMapper接口的类
	 *            ,在queryData方法的的while循环中，
	 *            回调实现了该接口的类中的rowMpper方法，来实现将结果集中的内容封装到对应的VO类中.
	 * 
	 * @param 查询语句中的
	 *            ?占位符的值 //考虑使用泛型 select * from emp where empno=?
	 * 
	 */
	// GoodTypeRowMapper GoodTypeVo
	// DeptVo
	// 泛型方法
	public <T> ArrayList<T> queryData(String sql, RowMapper<T> rowMapper,
			Object... values) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<T> dataList = new ArrayList<T>();
		try {
			//conn = JdbcUtil.getConnection();
			conn=JdbcUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			if (values != null) {
				for (int i = 0; i < values.length; i++) { // 长度为1
					pstmt.setObject(i + 1, values[i]);
				}
			}

			res = pstmt.executeQuery();

			while (res.next()) {
				T object = rowMapper.rowMapper(res);// 调用接口中的方法，
				dataList.add(object);// 添加vo对象到结果ArrayList中...
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}

		return dataList;

	}

	
	
	/**
	 * 该方法用于根据主键查询，返回单个对象
	 */
	public <T> T queryDataById(String sql, Integer id, RowMapper<T> rowMapper) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			// 只返回一行数据
			//conn = JdbcUtil.getConnection();
			conn=JdbcUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			if (id != null) {
				pstmt.setObject(1, id);
			}
			res = pstmt.executeQuery();
			if (res.next()) {
				T object = rowMapper.rowMapper(res);
				return object;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return null;
	}
	
	
	
	
	public <T> T queryDataById(String sql, Class<T> cls,
			Object id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			//conn = JdbcUtil.getConnection();
			conn=JdbcUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setObject(1, id);

			res = pstmt.executeQuery();
			ResultSetMetaData metaData = res.getMetaData();
			if (res.next()) {
				// 将数据保存到HashMap中
				HashMap<String, Object> rowValues = new HashMap<String, Object>();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					rowValues.put(metaData.getColumnName(i + 1).toLowerCase(),
							res.getObject(metaData.getColumnName(i + 1)));
				}
				
				T t = setValueToVo(rowValues, cls);//反射,将数据封装到VO类中
				return t;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}

		return null;
	}

	
	
	
	
	
	
	
	
	
}
