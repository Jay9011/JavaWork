package com.lec.spring.config03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.spring.beans.Score;

@Configuration
public class AppConfig03 {
	@Bean
	public Score score1() {	// id "score1" 의 Score Bean 생성
		return new Score(60, 30, 45, "나빠요");
	} // end Bean id="score1"
}
