package com.lec.spring.config02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.spring.beans.Score;
import com.lec.spring.beans.Student;

// Java 클래스를 이용한 설정
// 클래스 이름앞에 반드시 어노테이션 명시 필요
// @Configuration --> 이 클래스는 '스프링 설정' 에 사용되는 클래스입니다.
// 결국 컨테이너 역할을 한다.

@Configuration
public class AppConfig02 {
	@Bean
	public Score score1() {	// 메소드 이름 score1 이 bean 의 id값(name값) 이 된다.
		return new Score(100, 85, 75, "좋아요");
	} // end Bean id="score1"
	
	@Bean
	public Student stu1() {
		return new Student("훈지예지", 35, score1());
	} // end Bean id="stu1"
	
} // end Class
