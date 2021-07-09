package kr.ac.kopo.kopo42.board.service;

import java.util.ArrayList;

import kr.ac.kopo.kopo42.board.dao.CommentDao;
import kr.ac.kopo.kopo42.board.dao.CommentDaoImpl;
import kr.ac.kopo.kopo42.board.domain.Comment;


public class CommentServiceImpl implements CommentService {
	private CommentDao commentDao = new CommentDaoImpl();

	@Override
	public boolean update(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int idx, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCnt(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Comment> getList(int ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment getOne(int ref) {
		// TODO Auto-generated method stub
		return null;
	}


}
