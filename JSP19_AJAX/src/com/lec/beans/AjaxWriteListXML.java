package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

// POJO : Plain Old Java Object
//
@JacksonXmlRootElement(localName = "WriteList")
public class AjaxWriteListXML {
	private int count;	// 데이터 개수
	private String status;	// 처리 결과

	@JsonIgnore	// response 원하지 않는 필드에 Annotation을 쓴다.
	private String memo;	// response 에서 제외할 필드

	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "Data")
	private List<WriteDTO> list;

	public int getCount() { return count; }

	public void setCount(int count) { this.count = count; }

	public String getStatus() { return status; }

	public void setStatus(String status) { this.status = status; }

	public String getMemo() { return memo; }

	public void setMemo(String memo) { this.memo = memo; }

	public List<WriteDTO> getList() { return list; }

	public void setList(List<WriteDTO> list) { this.list = list; }
}
