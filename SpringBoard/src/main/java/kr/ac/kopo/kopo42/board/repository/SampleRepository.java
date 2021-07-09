package kr.ac.kopo.kopo42.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo42.board.domain.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long>, JpaSpecificationExecutor<Sample> {
	//<다루려는 도메인, 도메인에서 식별자로 사용하는 변수(id)의 타입>
	Optional<Sample> findOneByTitle(String title);
	//optional: 검색 값이 없을 경우에도 안전하게
	
	Page<Sample> findAllByTitle(String title, Pageable pageable);
	
	List<Sample> findAllByTitle(String title);
}
