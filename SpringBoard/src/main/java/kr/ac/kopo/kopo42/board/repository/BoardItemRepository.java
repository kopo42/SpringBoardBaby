package kr.ac.kopo.kopo42.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.kopo42.board.domain.BoardItem;

	@Repository
	public interface BoardItemRepository extends JpaRepository<BoardItem, Long>, JpaSpecificationExecutor<BoardItem> {
		//<다루려는 도메인, 도메인에서 식별자로 사용하는 변수(id)의 타입>
		Optional<BoardItem> findOneByTitle(String title);
		//optional: 검색 값이 없을 경우에도 안전하게
		
		Page<BoardItem> findAllByTitle(String title, Pageable pageable);
		
		List<BoardItem> findAllByTitle(String title);
	}
