package com.jdbc.util;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * ��ӳ�����ӿ�
 * @author Administrator
 *ArrayList<Emp>  al
 
 *
 */
public interface RowMapper<T> {	//����ӿ�Ϊ���ͽӿ�
	//�����ķ������ͣ����ݷ��͵����;���
	public T rowMapper(ResultSet res) throws SQLException ;
}
