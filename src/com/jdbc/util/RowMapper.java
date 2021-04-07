package com.jdbc.util;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 行映射器接口
 * @author Administrator
 *ArrayList<Emp>  al
 
 *
 */
public interface RowMapper<T> {	//定义接口为泛型接口
	//方法的返回类型，根据泛型的类型决定
	public T rowMapper(ResultSet res) throws SQLException ;
}
