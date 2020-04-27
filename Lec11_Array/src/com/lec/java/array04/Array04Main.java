package com.lec.java.array04;

import java.util.Scanner;

/*
 * 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤
 * 
 * 총점, 평균, 최대값, 최소값 출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");

		Scanner sc = new Scanner(System.in);

		int[] score = new int[5];
		int sum = 0;
		int max, min;
		double avg = 0.0;

		// 키보드로 입력을 받아서 배열 원소를 5개를 초기화
		for (int i = 0; i < 5; i++) {
			score[i] = sc.nextInt();
		}

		max = score[0];
		min = score[0];

		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			if (max < score[i]) {
				max = score[i];
			}
			if (min > score[i]) {
				min = score[i];
			}
		}

		avg = (double)sum / score.length;

		System.out.println("총점 : " + sum + ", 평균 : " + avg + ", 최대값 : " + max + ", 최소값 : " + min);

		sc.close();

	} // end main()

} // end class Array04Main
