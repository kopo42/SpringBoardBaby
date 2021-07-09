package board.dao;

import java.util.List;

import board.domain.Board;
import board.domain.BoardItem;

public interface BoardItemDao {
	int newID();
	List<Integer> getPage(int page);
	void create(BoardItem boardItem);
	BoardItem selectOne(int id);
	List<BoardItem> selectAll(int startRow, int endRow);
	void update(BoardItem boardItem);
	void delete(int id);
	List<BoardItem> search(String key);
	int getSearchCnt(String key);
}
