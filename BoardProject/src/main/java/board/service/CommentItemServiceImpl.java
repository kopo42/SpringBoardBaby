package board.service;

import java.util.ArrayList;

import board.dao.CommentItemDao;
import board.dao.CommentItemDaoImpl;
import board.domain.CommentItem;

public class CommentItemServiceImpl implements CommentItemService {
	private CommentItemDao commentItemDao = new CommentItemDaoImpl();

	@Override
	public boolean update(CommentItem comItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int idx, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(CommentItem comItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCnt(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CommentItem> getList(int ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentItem getOne(int ref) {
		// TODO Auto-generated method stub
		return commentItemDao.getOne(ref);
	}

}
