package com.lec.java.class06;

public class Score {
	// 멤버변수 : 
	// 	학생 이름 String
	// 	국어점수 int 
	// 	수학점수 int
	// 	영어점수 int
	String name;
	int lanScore;
	int matScore;
	int engScore;
	
	// 생성자: 멤버 변수 초기화
	//   1) 디폴트 생성자
	public Score() {
		super();
	}
	
	//   2) 매개변수 받는 생성자 (이름, 국어점수, 수학점수, 영어점수)
	public Score(String name, int lanScore, int matScore, int engScore) {
		super();
		this.name = name;
		this.lanScore = lanScore;
		this.matScore = matScore;
		this.engScore = engScore;
	}
	
	// 메소드
	// 총점계산 메소드
	// 메소드이름 :calcTotal()
	// 리턴타입 : int
	public int calcTotal() {
		return lanScore + matScore + engScore;
	}
	
	public int calcTotal(int lanScore, int matScore, int engScore) {
		return lanScore + matScore + engScore;
	}
	
	
	// 평균계산 메소드
	// 메소드 이름 : calcAvg()
	// 리턴타입 : double
	public double calcAvg() {
		return (lanScore + matScore + engScore) / 3.0;
	}
	
	public double calcAvg(int lanScore, int matScore, int engScore) {
		return (lanScore + matScore + engScore) / 3.0;
	}
	
	// 메소드
	// 이름: displayInfo()
	// 리턴: void
	// 매개변수: none
	//   학생의 이름, 국어, 영어, 수학 점수 출력
	public void displayInfo() {
		System.out.println("--------------------------");
		System.out.println("이름 : " + this.name);
		System.out.println("국어 점수 : " + this.lanScore);
		System.out.println("수학 점수 : " + this.matScore);
		System.out.println("영어 점수 : " + this.engScore);
		System.out.println("--------------------------");
	}
	
	
	
}


















