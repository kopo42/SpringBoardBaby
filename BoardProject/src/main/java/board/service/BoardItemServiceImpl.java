package board.service;

import java.util.List;

import board.dao.BoardItemDao;
import board.dao.BoardItemDaoImpl;
import board.domain.BoardItem;

public class BoardItemServiceImpl implements BoardItemService {
	private BoardItemDao boardItemDao = new BoardItemDaoImpl();
	@Override
	public int newID() {
		return boardItemDao.newID();
	}

	@Override
	public void create(BoardItem boardItem) {
		boardItemDao.create(boardItem);
	}

	@Override
	public BoardItem selectOne(int id) {
		return boardItemDao.selectOne(id);
	}

	@Override
	public List<BoardItem> selectAll(int startRow, int endRow) {
	  return boardItemDao.selectAll(startRow, endRow);
	}

	@Override
	public void update(BoardItem boardItem) {
		boardItemDao.update(boardItem);
	}

	@Override
	public void delete(int id) {
		boardItemDao.delete(id);
	}

	@Override
	public List<Integer> getPage(int page) {
		// TODO Auto-generated method stub
		return boardItemDao.getPage(page);
	}

	@Override
	public List<BoardItem> search(String key) {
		// TODO Auto-generated method stub
		return boardItemDao.search(key);
	}

	@Override
	public int getSearchCnt(String key) {
		// TODO Auto-generated method stub
		return boardItemDao.getSearchCnt(key);
	}



}
