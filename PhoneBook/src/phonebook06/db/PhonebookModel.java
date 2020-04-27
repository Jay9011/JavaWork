package phonebook06.db;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

// MODEL 객체
// 데이터 표현 객체
public class PhonebookModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7457878413286439105L;
	// 멤버변수
	private int uid;       // unique id
	private String name;     // 이름
	private String phoneNum; // 전화번호
	private String memo; 	// 메모
	private Date regDate;   // 등록일시
	
	// 기본생성자
	public PhonebookModel() {
		this.name = "";
		this.phoneNum = "";
		this.memo = "";
		this.regDate = new Date();  // 생성되는 현재시간.
	}
	// 매개변수 생성자
	public PhonebookModel(String name, String phoneNum, String memo) {
		this();
		this.name = name;
		this.phoneNum = phoneNum;
		this.memo = memo;
	}
	
	public PhonebookModel(int uid, String name, String phoneNum, String memo, Date regDate) {
		super();
		this.uid = uid;
		this.name = name;
		this.phoneNum = phoneNum;
		this.memo = memo;
		this.regDate = regDate;
	}
	
	
	// getter & setter
	public int getUid() {return uid;}
	public void setUid(int uid) {this.uid = uid;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	public String getMemo() {return memo;}
	public void setMemo(String memo) {this.memo = memo;}
	public Date getRegDate() {return regDate;}
	public void setRegDate(Date regDate) {this.regDate = regDate;}
	
	@Override
	public String toString() {
		String str = String.format("%3d|%s|%s|%s|%20s", 
				uid, name, phoneNum, memo, 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate));
		return str;
	}
	
	
}














