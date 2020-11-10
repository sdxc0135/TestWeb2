package com.TestWeb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	
	private static DataSource ds;
	private static Context cs;
	
	static {
		try {
		 	cs = new InitialContext();
		 	ds = (DataSource) cs.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("커넥션 풀 생성 에러");
		}
	}
	
	private JdbcUtil() {
		// TODO Auto-generated constructor stub
	}
	
	//커넥션 얻기
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	//커넥션 연결 종료
	public static void close(Connection con, PreparedStatement prst, ResultSet rs) {
		
		try {
			if(rs != null) rs.close();
			if(prst != null) prst.close();
			if(con != null) con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("----연결종료 에러----");
		}
	}
	
	//PreparedStatement에 데이터 삽입
	public static boolean inputData(PreparedStatement prst, Object... obj) {
		
		try {
			for(int i = 0; i < obj.length ; i++) {
				if(obj[i] instanceof String) {
					prst.setString(i+1, (String) obj[i]);
				}else if(obj[i] instanceof Integer) {
					prst.setInt(i+1, (int) obj[i]);
				}else if(obj[i] instanceof Timestamp) {
					prst.setTimestamp(i+1, (Timestamp) obj[i]);
				}else {
					prst.setNull(i+1, i+1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("----prst 데이터 삽입 실패----");
			return false;
		}
		return true;
	}


}
