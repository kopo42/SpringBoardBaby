package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.domain.CommentItem;

public interface CommentItemDao {
	
	public boolean update(CommentItem comItem);
	
	public boolean delete(int idx, String passwd);
	
	public void insert(CommentItem comItem);
	
	public int getCnt(int idx);
	
	public ArrayList<CommentItem> getList(int ref);
	
	public CommentItem getOne(int ref);
}