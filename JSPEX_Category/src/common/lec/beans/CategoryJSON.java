package common.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryJSON extends JSONBase{
	@JsonProperty("data")
	private List<CategoryDTO> list;

	public List<CategoryDTO> getList() { return list; }

	public void setList(List<CategoryDTO> list) { this.list = list; }

}
