package com.TestWeb.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.TestWeb.util.JdbcUtil;

public class UserDAO {
	
	//singleton pattern ���� ����
	private static UserDAO instance = new UserDAO();
	
	private UserDAO() {
	}

	static public  UserDAO getInstance() {
		return instance;
	}
	
	private Connection con = null;
	private PreparedStatement prst = null;
	private ResultSet rs = null;
	
	public int join(UserDTO user) {
		
		int result = 0;
		
		String sql = "insert into testweb_user(id, pw, name, phone_number1, phone_number2, phone_number3, "
				+ "email1, email2, address1, address2) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			
			JdbcUtil.inputData(prst, 
					user.getId(), 
					user.getPw(), 
					user.getName(),
					user.getPhone_number1(),
					user.getPhone_number2(),
					user.getPhone_number3(),
					user.getEmail1(),
					user.getEmail2(),
					user.getAddress1(),
					user.getAddress2()
					);
				
			if((result = prst.executeUpdate()) > 0){
				System.out.println("회원 가입 성공");
			}else {
				System.out.println("회원 가입 실패");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, prst, null);
		}
		
		return result;
	}
	
	public int checkId(String id) {
		
		int result = 0;
		
		String sql = "select count(*) from testweb_user where id=?";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			prst.setString(1, id);
			
			rs = prst.executeQuery();
			
			if(rs.next() && rs.getInt(1) == 1) {
				result = 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, prst, null);
		}
		
		return result;
	}
	
	public UserDTO login(String id, String pw) {
		UserDTO result = null;
		
		String sql = "select * from testweb_user where id=? and pw=?";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			prst.setString(1, id);
			prst.setString(2, pw);
			
			rs = prst.executeQuery();
			
			if(rs.next()) {
				result = new UserDTO(
						rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("phone_number1"),
						rs.getString("phone_number2"),
						rs.getString("phone_number3"),
						rs.getString("email1"),
						rs.getString("email2"),
						rs.getString("address1"),
						rs.getString("address2"),
						null);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, prst, null);
		}
		
		return result;
	}

	public int delete(String id, String pw) {
		
		int result = 0;
		
		String sql = "delete from testweb_user where id=? and pw=?";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			prst.setString(1, id);
			prst.setString(2, pw);
			
			if(prst.executeUpdate() == 1) {
				result = 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, prst, null);
		}
		
		return result;
	}
	
	public int modify(UserDTO user) {
		
		int result = 0;
		
		String sql = "update testweb_user set pw=?, name=?, phone_number1=?, phone_number2=?, phone_number3=?, "
				+ "email1=?, email2=?, address1=?, address2=? "
				+ "where id=?";
		
		try {
			
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			
			JdbcUtil.inputData(prst, 
					user.getPw(), 
					user.getName(),
					user.getPhone_number1(),
					user.getPhone_number2(),
					user.getPhone_number3(),
					user.getEmail1(),
					user.getEmail2(),
					user.getAddress1(),
					user.getAddress2(),
					user.getId()
					);
				
			if(prst.executeUpdate() == 1) {
				result = 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, prst, null);
		}
		
		return result;
		
		
	}
}
