package com.lec.sts19_rest.board.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")	// <employees></employees> 로 시작
public class EmployeeListVO {
	// List 멤버		// 배열이 Xml 로 만들어질 때 여러 Element 들이 생성된 것 처럼	
	@XmlElement		// <emp></emp> ... 들로 만들어 진다.
	private List<EmployeeVO> emp = new ArrayList<>();

	public List<EmployeeVO> getEmployees() { return emp; }
	
} // end Class
