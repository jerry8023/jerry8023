package com.jdbc.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * 该类用于获得Connection对象
 * @author Administrator
 * 
 */
public class JdbcUtil {
	
	
	/*private static  final String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	private static  final String userName="SCOTT" ;
	private static  final String password="math" ;
*/

	
	private static JdbcUtil instance=null;
	
	// 定义URL ,用户名,密码静态属性
	private static  String url = "jdbc:oracle:thin:@";//127.0.0.1:1521:ORCL";
	private static  String userName ;
	private static  String password ;

		
	//单例模式，从配置文件读取信息。。。。。。	
	private JdbcUtil(){
		
		Properties properties=new Properties();
		FileReader reader=null;
		try {
			reader=new FileReader("lib/Oracle配置文件.properties");
			properties.load(reader);
			
			
			url+=properties.getProperty("OracleServerIP");
			url+=":";
			url+=properties.getProperty("OraclePort");
			url+=":";
			url+=properties.getProperty("OracleSid");
			
			userName=properties.getProperty("OracleUserName");
			password=properties.getProperty("OraclePassWord");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
			if(reader!=null){
				
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
	//使用静态代码块,加载数据库驱动
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	
	//获取连接
	public  Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
		
	}
	
	
	//关闭Connection,PreparedStatement,ResultSet
	public static void close(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		// 关闭连接
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public  static JdbcUtil getInstance() {
		
		if(instance==null){
			
			synchronized (JdbcUtil.class) {
				
				if(instance==null){
					
					instance=new JdbcUtil();
				}
			}
			
		}
		
		
		return instance;
	}

	
	
}
