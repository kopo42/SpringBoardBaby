package board.dao;

import java.util.List;

import board.domain.Board;

public interface BoardDao {
	void create(Board board);
	Board selectOne(int id);
	List<Board> selectAll();
	void update(Board board);
	void delete(int id);
}
