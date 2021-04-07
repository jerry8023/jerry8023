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
 * �������ڻ��Connection����
 * @author Administrator
 * 
 */
public class JdbcUtil {
	
	
	/*private static  final String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	private static  final String userName="SCOTT" ;
	private static  final String password="math" ;
*/

	
	private static JdbcUtil instance=null;
	
	// ����URL ,�û���,���뾲̬����
	private static  String url = "jdbc:oracle:thin:@";//127.0.0.1:1521:ORCL";
	private static  String userName ;
	private static  String password ;

		
	//����ģʽ���������ļ���ȡ��Ϣ������������	
	private JdbcUtil(){
		
		Properties properties=new Properties();
		FileReader reader=null;
		try {
			reader=new FileReader("lib/Oracle�����ļ�.properties");
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
	
	
	
	//ʹ�þ�̬�����,�������ݿ�����
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	
	//��ȡ����
	public  Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
		
	}
	
	
	//�ر�Connection,PreparedStatement,ResultSet
	public static void close(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		// �ر�����
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
