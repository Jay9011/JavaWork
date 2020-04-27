package com.lec.java.regexp05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 대표적인 정규 표현식 
 *  구글링 하면 대표적인 정규표현식들이 많이 구할수 있습니다.
 *  각 정규표현식들을 작성해보고
 *	매칭되는 문자열과 그렇지 않은 것들을 출력해봅시다.   
 */
public class RegExp05Main {

	public static void main(String[] args) {
		System.out.println("많이 쓰는 정규표현식");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "URL";
		regex = "^((http|https)://)?(www.)?([a-zA-Z0-9]+)\\.[a-z]+([a-zA-Z0-9.?#]+)?"; // TODO
		arrInput = new String[] {
				"https://naver.com",
				"http:web.site",
				"naver.com",
				"www.web.site",
				"https://web.site.sth",
				"http://web.site",
				"https://june.me"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		
		//─────────────────────────────────────────
		title = "email";
		regex = "^[\\w._%+-]+@[\\w.-]+[.][a-zA-Z]{2,6}$"; // TODO
		arrInput = new String[] {
			"trowell123@naver.com",
			"test01.web.site",
			"test01@web.site",
			"whdtjq5904@Google.org"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "주민등록번호";
		regex = "^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])-[1-4][0-9]{6}$"; // TODO
		arrInput = new String[] {
			"901107-1234567",
			"1234-56789",
			"103323-2434543"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "날짜 YYYY-MM-DD";
		regex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|[3][01])$"; // TODO
		arrInput = new String[] {
			"2020-03-23",
			"9999-13-21",
			"1999-12-32"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "자연수";
		regex = "^[1-9]\\d*$"; // TODO
		arrInput = new String[] {
			"0",
			"12",
			"-13",
			"1.23"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "정수";
		regex = "^-?\\d+$"; // TODO
		arrInput = new String[] {
			"13",
			"-2",
			"0",
			"1.2"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소수";
		regex = "^-?\\d+[.]\\d+$"; // TODO
		arrInput = new String[] {
			"13",
			"-2",
			"0",
			"1.2",
			"-1.2",
			"10.2"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소숫점 둘째자리까지";
		regex = "^-?\\d+([.]\\d{1,2})?$"; // TODO
		arrInput = new String[] {
			"13",
			"-2",
			"0",
			"1.2",
			"-1.23",
			"10.2",
			"10.23",
			"10.234"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		
		//─────────────────────────────────────────
		title = "통화표시 (￦)";
		regex = "^[1-9][0-9]{0,2}(,[0-9]{3})*$"; // TODO
		arrInput = new String[] {
			"123",
			"12,41",
			"1,112",
			"11124,52",
			"999,999,999,999"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		/*
*/
		
		System.out.println("프로그램 종료");

	} // end main()

	// 도우미 함수
	public static void regExpTest(String regex, String[] arrInput) {
		for (String input : arrInput)
			regExpTest(regex, input);
	}

	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);

		if(Pattern.matches(regex, input)) {
			System.out.println("   ●매칭●");
		} else {
			System.out.println("   Ⅹ매칭 없슴Ⅹ");
		}
		
		System.out.println();
	} // end regExpTest()

} // end class
