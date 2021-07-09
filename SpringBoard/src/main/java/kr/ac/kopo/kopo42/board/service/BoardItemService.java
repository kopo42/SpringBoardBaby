package kr.ac.kopo.kopo42.board.service;

import java.util.List;

import kr.ac.kopo.kopo42.board.domain.BoardItem;

public interface BoardItemService {
	int newID();
	void create(BoardItem boardItem);
	BoardItem selectOne(int id);
	List<BoardItem> selectAll(int startRow, int endRow);
	void update(BoardItem boardItem);
	void delete(int id);
	List<Integer> getPage(int page);
	List<BoardItem> search(String key);
	int getSearchCnt(String key);
	void write(BoardItem boardItem);
}
