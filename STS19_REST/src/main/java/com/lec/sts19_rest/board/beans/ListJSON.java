package com.lec.sts19_rest.board.beans;

import java.util.List;

public class ListJSON {
	private int count;
	private String status="FAIL";
	private String message="";
	private int page;
	private List<BWriteDTO> data;
	private int totalpage;
	private int totalcnt;
	private int writepages;
	private int pagerows;
	
	public int getCount() { return count; }
	public void setCount(int count) { this.count = count; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	public int getPage() { return page; }
	public void setPage(int page) { this.page = page; }
	public List<BWriteDTO> getData() { return data; }
	public void setData(List<BWriteDTO> data) { this.data = data; }
	public int getTotalpage() { return totalpage; }
	public void setTotalpage(int totalpage) { this.totalpage = totalpage; }
	public int getTotalcnt() { return totalcnt; }
	public void setTotalcnt(int totalcnt) { this.totalcnt = totalcnt; }
	public int getWritepages() { return writepages; }
	public void setWritepages(int writepages) { this.writepages = writepages; }
	public int getPagerows() { return pagerows; }
	public void setPagerows(int pagerows) { this.pagerows = pagerows; }
}
