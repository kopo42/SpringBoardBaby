package kr.ac.kopo.kopo42.board.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo42.board.domain.BoardItem;

@Repository
public class BoardItemRepositoryImpl implements BoardItemRepository {

	private static String namespace = "kr.ac.kopo.kopo42.board.repository.mapper.BoardItemMapper";
	@Override
	public List<BoardItem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends BoardItem> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<BoardItem> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardItem getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardItem getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BoardItem> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BoardItem> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BoardItem entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends BoardItem> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends BoardItem> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends BoardItem> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<BoardItem> findOne(Specification<BoardItem> spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAll(Specification<BoardItem> spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BoardItem> findAll(Specification<BoardItem> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAll(Specification<BoardItem> spec, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(Specification<BoardItem> spec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<BoardItem> findOneByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BoardItem> findAllByTitle(String title, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAllByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
