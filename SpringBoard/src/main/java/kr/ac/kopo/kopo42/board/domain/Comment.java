package kr.ac.kopo.kopo42.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "comment1")
public class Comment {
	@Id
	@GeneratedValue
	@Column
	private int idx;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="boarditem_id")
	@JsonBackReference
	private BoardItem boardItem;
	
	private String name;
	private String passwd;
	private String content;
	private Date rdate;
	private int ref;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public BoardItem getBoardItem() {
		return boardItem;
	}
	public void setBoardItem(BoardItem boardItem) {
		this.boardItem = boardItem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	
}
