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
	 *            Ҫִ��sql���
	 * @param values
	 *            ע�뵽sql����е�ֵ
	 * @return  1��ʾ�����ɹ���2��ʾ����ʧ��
	 */
	public int insertOrUpdateOrDelete(String sql, Object... values) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//conn = JdbcUtil.getConnection();
			conn=JdbcUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			if (values != null) { // �жϲ���values�Ƿ�Ϊ��
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
	 * �ø÷�������Ƶ�Vo������Ա�������ݿ�������Ʊ���һ��.
	 * @param sql
	 * @param cls
	 * @param values
	 * @return һ��VO�������һ�����ݡ����������еĶ��󶼷���һ�������С�������
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
				for (int i = 0; i < values.length; i++) { // ����Ϊ1
					pstmt.setObject(i + 1, values[i]);
				}
			}

			res = pstmt.executeQuery();
			ResultSetMetaData metaData = res.getMetaData();
			while (res.next()) {
				// �����ݱ��浽HashMap��
				HashMap<String, Object> rowValues = new HashMap<String, Object>();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					rowValues.put(metaData.getColumnName(i + 1).toLowerCase(),
							res.getObject(metaData.getColumnName(i + 1)));
				}
				
				T t = setValueToVo(rowValues, cls);//����,�����ݷ�װ��VO����
				
				dataList.add(t);//��Ӷ��󵽼�����

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

		// �õ�������з���
		Method[] methods = cls.getMethods();
		
		for (Method m : methods) {

			// �ж��Ƿ���set����
			String mthodName = m.getName();
			if (mthodName.startsWith("set")) {
				// �õ�set�����ĺ���,��setEmpno ȡ��empno,�ٴ�map��ͨ��empnoȡ����Ӧ��ֵ
				String mName = mthodName.substring(3).toLowerCase();

				// �жϷ����Ĳ������ͼ�����
				Class[] paramTyps = m.getParameterTypes();
				if (paramTyps != null && paramTyps.length == 1) {
					Object mapValues = values.get(mName);

					// ȡ����һ����������
					Class types = paramTyps[0];
					String typeName = types.getName();
					
					
					if (mapValues != null) {
						if (typeName.equals("java.lang.String")) {
							if (mapValues instanceof String) {
								m.invoke(obj, mapValues.toString());
							}
						} else if (typeName.equals("int")
								|| typeName.equals("java.lang.Integer")) {
							// �ж�mapValues�Ƿ���ת����int����
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
								// Object ��ôת����java.sql.Date����
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
							
						}else if (typeName.equals("[B")){//�жϷ����Ĳ����Ƿ���byte[]����
							//ȡ��Blob����
							if (mapValues instanceof oracle.sql.BLOB){
								//ͨ��IO������Blob�������ݶ�ȡ������byte[]���͵ķ���setPhoto(byte[] b)
								BLOB blob = (BLOB) mapValues;
								// ��������,���ڽ������ϵ��ļ���д�뵽�������
								InputStream intInputStream = blob.getBinaryStream();

								ByteArrayOutputStream out = new ByteArrayOutputStream();

								// IO���У���������������д�뵽�ֽ�����
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
					
					//���е�VO��ŵ�һ������,���´��봦����EmpVO�а���DeptVo�����
					if (typeName.startsWith("com.vo.")){ //typename "com.vo.DeptVo"
						 //��ν���ѯ����洢��DeptVo��
						 //��ȻҪ��ֵд��DeptVo�У��Ƿ���Ҫʵ����һ��DeptVo��
						 Class innerCls = Class.forName(typeName);
						
						 //�ٵ���һ��setValueToVo
						 Object vl = setValueToVo(values, innerCls);
						 
						 //����Ҫ��ʵ�����õ��࣬set��EmpVo�е�setDept(com.vo.DetpVo)
						 m.invoke(obj, vl);
						
					}

				}

			}

		}

		return obj;

	}

	
	//��ѯ���������ص���Vector�������ݣ����ڽ�������ʾ��JTable��
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
				for (int i = 0; i < values.length; i++) { // ����Ϊ1
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

				dataList.add(rowData);// ��Ӷ��󵽼�����
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}

		return dataList;
	}
	
	
	
	/**
	 * ����һ��ͨ�õĲ�ѯ����,�������еĲ�ѯ����ض�Ӧ�ļ���
	 * 
	 * queryData������һ�����ͷ������÷����ķ���ֵ���Ǹ��ݴ����RowMapper��ʵ�����ͣ�����queryDate�����ķ�������
	 * 
	 * 
	 * @param sql
	 *            �����ѯ���
	 * @param ����ʵ����RowMapper�ӿڵ���
	 *            ,��queryData�����ĵ�whileѭ���У�
	 *            �ص�ʵ���˸ýӿڵ����е�rowMpper��������ʵ�ֽ�������е����ݷ�װ����Ӧ��VO����.
	 * 
	 * @param ��ѯ����е�
	 *            ?ռλ����ֵ //����ʹ�÷��� select * from emp where empno=?
	 * 
	 */
	// GoodTypeRowMapper GoodTypeVo
	// DeptVo
	// ���ͷ���
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
				for (int i = 0; i < values.length; i++) { // ����Ϊ1
					pstmt.setObject(i + 1, values[i]);
				}
			}

			res = pstmt.executeQuery();

			while (res.next()) {
				T object = rowMapper.rowMapper(res);// ���ýӿ��еķ�����
				dataList.add(object);// ���vo���󵽽��ArrayList��...
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}

		return dataList;

	}

	
	
	/**
	 * �÷������ڸ���������ѯ�����ص�������
	 */
	public <T> T queryDataById(String sql, Integer id, RowMapper<T> rowMapper) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			// ֻ����һ������
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
				// �����ݱ��浽HashMap��
				HashMap<String, Object> rowValues = new HashMap<String, Object>();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					rowValues.put(metaData.getColumnName(i + 1).toLowerCase(),
							res.getObject(metaData.getColumnName(i + 1)));
				}
				
				T t = setValueToVo(rowValues, cls);//����,�����ݷ�װ��VO����
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
