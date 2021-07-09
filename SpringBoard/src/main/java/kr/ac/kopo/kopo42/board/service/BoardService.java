package kr.ac.kopo.kopo42.board.service;

import java.util.List;

import kr.ac.kopo.kopo42.board.domain.Board;

public interface BoardService {
	void create(Board board);
	Board selectOne(long id);
	List<Board> selectAll();
	void update(Board board);
	void delete(Board board);
}
