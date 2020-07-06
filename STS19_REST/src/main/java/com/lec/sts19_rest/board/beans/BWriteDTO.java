package com.lec.sts19_rest.board.beans;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

// DB에서 사용할 값들 멤버변수로 지정해주기
public class BWriteDTO {
	private Integer uid;
	private String subject;
	private String content;
	private String name;
	private int viewCnt;
	private Timestamp regDate;
	
	public BWriteDTO() {
		super();
	}
	// 생성할 때 한 번에 값 넣기
	public BWriteDTO(Integer uid, String subject, String content, String name, int viewCnt, Timestamp regDate) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}
	public Integer getUid() { return uid; }
	public void setUid(Integer uid) { this.uid = uid; }
	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getViewCnt() { return viewCnt; }
	public void setViewCnt(int viewCnt) { this.viewCnt = viewCnt; }
	public Timestamp getRegDate() { return regDate; }
	public void setRegDate(Timestamp regDate) { this.regDate = regDate; }
	
	public String getRegDate2() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate);
	}
}
