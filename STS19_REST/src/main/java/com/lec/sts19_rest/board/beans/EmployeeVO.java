package com.lec.sts19_rest.board.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")	// <employee></employee> 로 시작
public class EmployeeVO {
	@XmlAttribute	// "id" : Attribute 로 정의
	private Integer id;
	@XmlElement		// <name> : Element 로 정의
	private String name;
	@XmlElement		// <age> : Element 로 정의
	private int age;
	@XmlElement		// <score> : Elements 로 정의
	private int[] score;
	
	private double point;	// Annotation 이 없으면 XML 에 포함 안됨.

	// 기본 생성자
	public EmployeeVO() {
		super();
	}
	// 매개변수 생성자
	public EmployeeVO(Integer id, String name, int age, int[] score, double point) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.point = point;
	}
	/**
	 * getter 만 제공 : read-only 속성, Immutable
	 * @return
	 */
	public Integer getId() { return id; }
	public String getName() { return name; }
	public int getAge() { return age; }
	public int[] getScore() { return score; }
	public double getPoint() { return point; }
	
} // end Class
