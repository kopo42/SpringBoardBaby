package kr.ac.kopo.kopo42.board.dao;


import java.util.ArrayList;

import kr.ac.kopo.kopo42.board.domain.Comment;

public interface CommentDao {
	
	public boolean update(int idx, String passwd);
	
	public boolean delete(int idx, String passwd);
	
	public void insert(Comment com);
	
	public int getCnt(int idx);
	
	public ArrayList<Comment> getList(int ref);
	
	public Comment getOne(int ref);
}