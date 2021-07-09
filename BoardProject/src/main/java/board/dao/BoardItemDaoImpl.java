package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import board.domain.Board;
import board.domain.BoardItem;

public class BoardItemDaoImpl implements BoardItemDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	
	@Override
	public int newID() {
		ResultSet rset_max;
		int newID = 0;
		
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			rset_max = stmt.executeQuery("select max(id) from board1;");

		    while(rset_max.next()){
		        if ( rset_max.getInt(1) > 1){
		          newID = rset_max.getInt(1) + 1;
		          break;
		        } else {
		            newID = 1;
		            break;
		      }
			}
		  } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		  return newID;
	}

	@Override
	public void create(BoardItem itemToInsert) {
		Statement stmt_insert;
		Statement stmt_insert2;
		Statement stmt_delete;
		
		String tmp = "";
		String tmp2 = "";
		
		int _id = 0;
		String _title = "";
		String _content = "";
		String _date = "";
		
		_id = itemToInsert.getId();
		_title = itemToInsert.getTitle();
		_date = itemToInsert.getDate();
		_content = itemToInsert.getContent();
		
		tmp = "insert into board1 (id, title, date, content) values('" + _id + "','" + _title + "','" + _date + "','" + _content + "');";

		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt_insert = conn.createStatement();
			stmt_insert2 = conn.createStatement();
			stmt_delete = conn.createStatement();
			
			try{
			      stmt_insert.execute(tmp);
			    } catch(java.sql.SQLIntegrityConstraintViolationException e){
			        tmp = "delete from board1 where id =" + _id;
			        stmt_delete.execute(tmp);

			        tmp2 = "insert into board1 (id, title, date, content) values('" + _id + "','" + _title + "','" + _date + "','" + _content + "');";
			        stmt_insert2.execute(tmp2);
			    } catch (java.sql.SQLException e){
			    	tmp = "delete from board1 where id =" + _id;
			        stmt_delete.execute(tmp);

			        tmp2 = "insert into board1 (id, title, date, content) values('" + _id + "','" + _title + "','" + _date + "','" + _content + "');";
			        stmt_insert2.execute(tmp2);
			    }
			
			stmt_insert.close();
		    stmt_insert2.close();
		    stmt_delete.close();

		    conn.close();
		    
		  	} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public BoardItem selectOne(int id) {
		BoardItem boardItem = new BoardItem();
		
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			String sql = "select * from board1 where id=" + id;
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				boardItem.setId(rset.getInt(1));
				boardItem.setTitle(rset.getString(2));
				boardItem.setDate(rset.getString(3));
				boardItem.setContent(rset.getString(4));
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return boardItem;
	}

	@Override
	public List<BoardItem> selectAll(int startRow, int endRow) {
		List<BoardItem> boardItems = new ArrayList<BoardItem>();
		List<Integer> pageData = new ArrayList<Integer>();
		
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery("select * from board1 where id between " + endRow + " and " + startRow + " order by id desc;");

			while(rset.next()) {
				BoardItem itemtmp = new BoardItem();
				itemtmp.setId(rset.getInt(1));
				itemtmp.setTitle(rset.getString(2));
				itemtmp.setDate(rset.getString(3));
				itemtmp.setContent(rset.getString(4));
				
				boardItems.add(itemtmp);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		  
		return boardItems;
	}
	
	@Override
	public List<Integer> getPage(int page) {
		int listCnt = 15;
		int totalCnt;
		int totalPage;
		int startPage;
		int endPage;
		int row_end;
		int row_start;
		
		Statement stmt_cnt;
		ResultSet rset_cnt;
		List<Integer> pageData = new ArrayList<Integer>();

		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			stmt_cnt = conn.createStatement();
		    rset_cnt = stmt_cnt.executeQuery("select count(*) from board1");
		    
		    totalCnt = 0;
		     while(rset_cnt.next()){
		        totalCnt = rset_cnt.getInt(1);
		     }
		     
		     totalPage = (totalCnt / listCnt);

		        if((totalCnt % listCnt) > 0){
		          totalPage++;
		        }

		        if(totalPage < page){
		          page = totalPage;
		        }
		        
		        startPage = ((page - 1) / listCnt) * listCnt + 1;
		        endPage = ((page - 1) / listCnt * listCnt) + listCnt;

		        if(endPage > totalPage){
		          endPage = totalPage;
		        }
		        row_start = totalCnt - ((page - 1) * listCnt);
		        row_end = row_start - (listCnt - 1);
		        
		        pageData.add(listCnt);
		        pageData.add(totalCnt);
		        pageData.add(totalPage);
		        pageData.add(startPage);
		        pageData.add(endPage);
		        pageData.add(row_end);
		        pageData.add(row_start);
		        
			rset_cnt.close();
			stmt_cnt.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pageData;
	}

	@Override
	public void update(BoardItem boardItem) {
		Connection conn;
		Statement stmt;
		PreparedStatement pstmt;
		ResultSet rset;
		
		int id = boardItem.getId();
		String title = boardItem.getTitle();
		String date = boardItem.getDate();
		String content = boardItem.getContent();
		
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			//stmt = conn.createStatement();
			
			
			String sql = "delete from board1 where id=" + id;
			pstmt = conn.prepareStatement("delete from board1 where id=?");
			pstmt.setInt(1, id);
			
			int tmp = pstmt.executeUpdate();
			
			//rset = stmt.executeQuery(sql);
			
			//rset.close();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		PreparedStatement pstmt;
		BoardItem boardItem = new BoardItem();
		
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			//stmt = conn.createStatement();
			
			
			String sql = "delete from board1 where id=" + id;
			pstmt = conn.prepareStatement("delete from board1 where id=?");
			pstmt.setInt(1, id);
			
			int tmp = pstmt.executeUpdate();
			
			//rset = stmt.executeQuery(sql);
			
			//rset.close();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardItem> search(String key) {
		List<BoardItem> searchItems = new ArrayList<BoardItem>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			Statement stmt_cnt = conn.createStatement();
		    ResultSet rset_cnt = stmt_cnt.executeQuery("select count(*) from board1 where title like '%" + key + "%'");
		     
		    int totalCnt = 0;
		      while(rset_cnt.next()){
		        totalCnt = rset_cnt.getInt(1);
		      }
		      
		    String select_str = "select * from board1 where title like '%" + key + "%'";

		    rset = stmt.executeQuery(select_str);
		      
			while(rset.next()) {
				BoardItem itemtmp = new BoardItem();
				itemtmp.setId(rset.getInt(1));
				itemtmp.setTitle(rset.getString(2));
				itemtmp.setDate(rset.getString(3));
				itemtmp.setContent(rset.getString(4));
				
				searchItems.add(itemtmp);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return searchItems;
	}

	@Override
	public int getSearchCnt(String key) {
		int totalCnt = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.109/kopo42", "root", "kopo42");
			stmt = conn.createStatement();
			
			Statement stmt_cnt = conn.createStatement();
		    ResultSet rset_cnt = stmt_cnt.executeQuery("select count(*) from board1 where title like '%" + key + "%'");
		     
		      while(rset_cnt.next()){
		        totalCnt = rset_cnt.getInt(1);
		      }
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return totalCnt;
	}
}
