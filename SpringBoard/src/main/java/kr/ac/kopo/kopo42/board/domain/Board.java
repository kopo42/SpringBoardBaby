package kr.ac.kopo.kopo42.board.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Board {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private String title;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="board") //fetchtype => child 가져오기 여부 설정 (eager (o) lazy(x))
	@JsonBackReference
	private List<BoardItem> boardItems;
	
	public List<BoardItem> getBoardItems() {
		return boardItems;
	}

	public void setBoardItems(List<BoardItem> boardItems) {
		this.boardItems = boardItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + "]";
	}
	
}
