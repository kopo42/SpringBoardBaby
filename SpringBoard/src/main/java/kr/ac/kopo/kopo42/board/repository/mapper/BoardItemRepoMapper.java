package kr.ac.kopo.kopo42.board.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo42.board.domain.BoardItem;

@Mapper
@Repository
public interface BoardItemRepoMapper {
	List<BoardItem> findAllItme();
	List<BoardItem> findByTitleItem(BoardItemCondition BoardItemCondition, RowBounds rowbounds);
}
