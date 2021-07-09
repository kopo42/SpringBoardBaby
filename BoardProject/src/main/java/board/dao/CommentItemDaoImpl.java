package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import board.dao.CommentItemDao;
import board.domain.CommentItem;

public class CommentItemDaoImpl implements CommentItemDao{
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rset = null;
	
	public static CommentItemDaoImpl comservice = new CommentItemDaoImpl();
	public CommentItemDaoImpl() {}
	public static CommentItemDaoImpl getInstance() {
		return comservice;
	}
	
//	public boolean update(CommentItem comItem) { //comItem = 사용자 입력값
//		boolean flag = false;
//		
//		try{
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
//			stmt = conn.createStatement();
//			
//			//DB에서 idx 검색
//			CommentItem res = comDao.getOne(comItem.getIdx());
//			if(res.getPasswd().equals(comItem.getPasswd())) {
//				comDao.update(comItem);
//				flag = true;
//			}
//		} catch(Exception e){
//			e.printStackTrace();
//		}
//		con.close();
//		return flag;
//	}
	
	public boolean delete(int idx, String passwd) {

		boolean flag = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			CommentItem comItem = new CommentItem();
			
			String tmp = "delete from comment1 where id =" + idx;
			if(comItem.getPasswd().equals(passwd)) {
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
	
	public void insert(CommentItem comItem){
		int idx = comItem.getIdx();
		String name = comItem.getName();
		String password = comItem.getPasswd();
		String content = comItem.getContent();
		Date rdate = comItem.getRdate();
		int ref = comItem.getRef();
		
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
	
//	public ArrayList<CommentItem> getList(int ref){
//		ArrayList<CommentItem> list = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
//			stmt = conn.createStatement();
//			
//			list = comDao.getList(ref);
//			
//		} catch (SQLException | ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	public CommentItem getOne(int ref) {
		CommentItem commentItem = new CommentItem();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			String tmp = "select * from comment1 where idx = " + ref;
			rset = stmt.executeQuery(tmp);
			while(rset.next()) {
				commentItem.setIdx(rset.getInt(1));
				commentItem.setName(rset.getString(2));
				commentItem.setPasswd(rset.getString(3));
				commentItem.setContent(rset.getString(4));
				commentItem.setRdate(rset.getDate(5));
				commentItem.setRef(rset.getInt(rset.getInt(6)));
			}
			rset.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return commentItem;
	}
	@Override
	public ArrayList<CommentItem> getList(int ref) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean update(CommentItem comItem) {
		// TODO Auto-generated method stub
		return false;
	}
}