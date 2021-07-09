package board.dao;

import java.util.List;

import board.domain.Board;

public class BoardDaoImpl implements BoardDao {

	@Override
	public void create(Board board) {
		
	}

	@Override
	public Board selectOne(int id) {
		Board board = new Board();
		return board;
	}

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
