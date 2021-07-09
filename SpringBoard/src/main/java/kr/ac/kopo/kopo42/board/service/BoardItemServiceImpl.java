package kr.ac.kopo.kopo42.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo42.board.dao.BoardItemDao;
import kr.ac.kopo.kopo42.board.dao.BoardItemDaoImpl;
import kr.ac.kopo.kopo42.board.domain.BoardItem;

@Service
public class BoardItemServiceImpl implements BoardItemService {
	
	@Inject
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

	@Override
	public void write(BoardItem boardItem) {
		boardItemDao.write(boardItem);
	}
}
