package com.lec.spring.ex1_1;

public class PrintInfo implements PrintText {

	String msg = "출력용 메세지";
	String addMsg;

	public PrintInfo() {
		super();
	}

	public PrintInfo(String msg, String addMsg) {
		super();
		this.msg = msg;
		this.addMsg = addMsg;
	}

	public String getMsg() { return msg; }
	public void setMsg(String msg) { this.msg = msg; }
	public String getAddMsg() { return addMsg; }
	public void setAddMsg(String addMsg) { this.addMsg = addMsg; }

	public String printer() {
		return msg + addMsg;
	}
}
