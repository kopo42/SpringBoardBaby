package kr.ac.kopo.kopo42.board.repository.mapper;

import java.io.Serializable;

public class BoardItemCondition implements Cloneable, Serializable {
	private static final long serialVersionUID = 01L;
	
	private long id;
	private String title;
	private String date;
	private String content;
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
