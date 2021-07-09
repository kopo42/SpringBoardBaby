package kr.ac.kopo.kopo42.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import kr.ac.kopo.kopo42.board.domain.Comment;

public class CommentDaoImpl implements CommentDao{
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rset = null;
	
	public static CommentDaoImpl comservice = new CommentDaoImpl();
	public CommentDaoImpl() {}
	public static CommentDaoImpl getInstance() {
		return comservice;
	}
	
	public boolean update(int idx, String passwd) { //comment = 사용자 입력값
		boolean flag = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			Comment comment = new Comment();
			
			String tmp = "delete from comment1 where id =" + idx;
			if(comment.getPasswd().equals(passwd)) {
				rset = stmt.executeQuery(tmp);
				flag = false;
			}
			rset.close();
			conn.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean delete(int idx, String passwd) {

		boolean flag = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			Comment comment = new Comment();
			
			String tmp = "delete from comment1 where id =" + idx;
			if(comment.getPasswd().equals(passwd)) {
				rset = stmt.executeQuery(tmp);
				flag = false;
			}
			rset.close();
			conn.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public void insert(Comment comment){
		int idx = comment.getIdx();
		String name = comment.getName();
		String password = comment.getPasswd();
		String content = comment.getContent();
		Date rdate = comment.getRdate();
		int ref = comment.getRef();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			String tmp = "insert into comment1 values(" + idx + ",'" + name + "','" + password + "','" + content + "','" + rdate + "','" + ref + ");";
			
			rset = stmt.executeQuery(tmp);
			
			rset.close();
			stmt.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getCnt(int idx) {
		int cnt = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			String tmp = "select count(*) from comment1 where idx =" + idx;
			rset = stmt.executeQuery(tmp);
			cnt = rset.getInt(1);
			rset.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	public ArrayList<Comment> getList(int ref){
		ArrayList<Comment> list = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			//list = comDao.getList(ref);
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Comment getOne(int ref) {
		Comment Comment = new Comment();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			String tmp = "select * from comment1 where idx = " + ref;
			rset = stmt.executeQuery(tmp);
			while(rset.next()) {
				Comment.setIdx(rset.getInt(1));
				Comment.setName(rset.getString(2));
				Comment.setPasswd(rset.getString(3));
				Comment.setContent(rset.getString(4));
				Comment.setRdate(rset.getDate(5));
				Comment.setRef(rset.getInt(rset.getInt(6)));
			}
			rset.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Comment;
	}
}