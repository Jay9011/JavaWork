package common.lec.beans;

public class JSONBase {
	private int count;
	private String status;
	private String message;

	public JSONBase() {
		super();
	}

	public int getCount() { return count; }
	public void setCount(int count) { this.count = count; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
}
