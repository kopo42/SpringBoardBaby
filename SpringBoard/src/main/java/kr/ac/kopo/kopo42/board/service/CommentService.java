package kr.ac.kopo.kopo42.board.service;

import java.util.ArrayList;

import kr.ac.kopo.kopo42.board.domain.Comment;

public interface CommentService {
	
	public boolean update(Comment comment);
	
	public boolean delete(int idx, String passwd);
	
	public void insert(Comment comment);
	
	public int getCnt(int idx);
	
	public ArrayList<Comment> getList(int ref);
	
	public Comment getOne(int ref);
}