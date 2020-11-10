package com.TestWeb.Board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TestWeb.util.JdbcUtil;

public class BoardDAO {

	// singleton pattern ���� ����
	private static BoardDAO instance = new BoardDAO();


	static public BoardDAO getInstance() {
		return instance;
	}
	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private Connection con = null;
	private PreparedStatement prst = null;
	private ResultSet rs = null;
	
	public int getCount() {
		int result = 0;
		
		String sql = "select count(*) from testweb_board";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			
			rs = prst.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, prst, rs);
		}
		
		
		return result;
	}
	
	public List<BoardDTO> getList(int page, int contentAmount){
		
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		int beginContent = (page-1)*contentAmount+1;
		int endContent = beginContent + contentAmount-1;
		
		System.out.println();
		
		String sql = "select * from (select rownum as rnum, a.* from (select * from testweb_board order by bno desc) a) "
				+ "where rnum between ? and ?";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			prst.setInt(1, beginContent);
			prst.setInt(2, endContent);
			
			rs = prst.executeQuery();
			
			while(rs.next()) {
				list.add(new BoardDTO(
						rs.getInt("bno"), 
						rs.getString("title"), 
						rs.getString("writer"), 
						null, 
						rs.getTimestamp("regdate"))
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, prst, rs);
		}
		
		return list;
	}
	
	public int getUserCount(String id) {
		int result = 0;
		
		String sql = "select count(*) from testweb_board where writer=?";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			prst.setString(1, id);
			
			rs = prst.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, prst, rs);
		}
		
		
		return result;
	}
	
	public List<BoardDTO> getUserList(int page, int contentAmount, String id){
		
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		int beginContent = (page-1)*contentAmount+1;
		int endContent = beginContent + contentAmount-1;
		
		System.out.println();
		
		String sql = "select * from (select rownum as rnum, a.* from (select * from testweb_board where writer =? order by bno desc) a) "
				+ "where rnum between ? and ?";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			prst.setString(1, id);
			prst.setInt(2, beginContent);
			prst.setInt(3, endContent);
			
			rs = prst.executeQuery();
			
			while(rs.next()) {
				list.add(new BoardDTO(
						rs.getInt("bno"), 
						rs.getString("title"), 
						rs.getString("writer"), 
						null, 
						rs.getTimestamp("regdate"))
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, prst, rs);
		}
		
		return list;
	}

	public String getWriter(String bno) {
		
		String result = null;
		String sql = "select writer from testweb_board where bno = ?";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			prst.setString(1, bno);
			
			rs = prst.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("writer");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, prst, rs);
		}
		
		return result;
			
	}
		
	public int insert(String title, String writer, String content) {
		
		int result = 0;
		
		String sql = "insert into testweb_board(title, writer, content) values(?,?,?)";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			
			JdbcUtil.inputData(prst, title, writer, content);
			
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
	
	public int delete(int bno) {
		int result = 0;
		
		String sql = "delete from testweb_board where bno = ?";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			prst.setInt(1, bno);
			
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
	
	public BoardDTO getContent(int bno) {
		
		BoardDTO dto = null;
		
		String sql = "select bno, title, writer, content, regdate from testweb_board where bno=?";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			prst.setInt(1, bno);
			
			rs = prst.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO(
						rs.getInt("bno"), 
						rs.getString("title"), 
						rs.getString("writer"), 
						rs.getString("content"), 
						rs.getTimestamp("regdate")
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, prst, rs);
		}
		
		return dto;
		
	}
	
	public int modify(String title, String content, int bno) {
		
		int result = 0;
		
		String sql = "update testweb_board set title=?, content=? where bno = ?";
		
		try {
			con = JdbcUtil.getConnection();
			prst = con.prepareStatement(sql);
			
			JdbcUtil.inputData(prst, title, content, bno);
			
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
