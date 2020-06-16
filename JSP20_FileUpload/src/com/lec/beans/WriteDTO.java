package com.lec.beans;

/**
 * @DTO : Data Transfer Object
 *      Data를 담아 나르기 위한 객체.
 *
 *      게시글DTO, 회원DTO, ... 필요한 데이터 객체들 만큼 정의
 *      (Bean 객체)
 */
public class WriteDTO {
	private int uid; // wr_uid
	private String subject; // wr_subject
	private String content; // wr_content
	private String name; // wr_name
	private int viewCnt; // wr_viewcnt
	private String regDate; // wr_regDate

	/**
	 * 개발시...
	 * 다음 3가지 네이밍은 일치시켜주는 것이 좋다.
	 *
	 * ※ 클래스 필드명 = DB 필드명 = Form name명
	 */
	// 기본 생성자, 매개변수 생성자, getter/setter
	public WriteDTO() {
		super();
	}

	public WriteDTO(int uid, String subject, String content, String name, int viewCnt) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	// TODO : 테스트, 개발용으로 toString() 오버라이딩하면 좋다.
	@Override
	public String toString() {
		return "WriteDTO] " + uid + " : " + subject + " : " + content + " : " + name + " : " + viewCnt + " : " + regDate;
	}

} // end DTO
