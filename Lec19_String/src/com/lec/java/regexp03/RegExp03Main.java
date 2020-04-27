package com.lec.java.regexp03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 정규표현식 에 사용하는 각종 표현식들
 * 	정규표현식		설명
 * 	^			문자열 시작
 * 	$			문자열 종료
 * 	.			임의의 문자 [단 ‘'는 넣을 수 없습니다.]
 * 	*			앞 문자가 0개 이상의 개수가 존재할 수 있습니다.
 * 	+			앞 문자가 1개 이상의 개수가 존재할 수 있습니다.
 * 	?			앞 문자가 없거나 하나 있을 수 있습니다.
 * []			문자의 집합이나 범위를 표현합니다. -기호를 통해 범위를 나타낼 수 있습니다. ^가 존재하면 not을 나타냅니다.
 * {}			횟수 또는 범위를 나타냅니다.
 * ()			괄호안의 문자를 하나의 문자로 인식합니다. (그룹)
 * |			패턴을 OR 연산을 수행할 때 사용합니다.
 * \s			공백 문자
 * \S			공백 문자가 아닌 나머지 문자
 * \w			알파벳이나 숫자
 * \W			알파벳이나 숫자를 제외한 문자
 * \d			[0-9] 숫자
 * \D			숫자를 제외한 모든 문자
 * (?i)			대소문자를 구분하지 않습니다.
 * 
 * 
 * 자바 정규표현식에 사용되는 escaped character 들
 *    \.[]{}()<>*+-=!?^$|
 */
public class RegExp03Main {

	public static void main(String[] args) {
		System.out.println("정규표현식\n");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "^ : 바로 문자뒤의 문자열로 시작됨";
		regex = "^The"; // The 로 시작하는 문자열 패턴
		arrInput = new String[] {
				"The Things",
				"On The Things",	// X, 앞에 The 로 시작하지 않음
				" The The The",		// X, 앞에 공백으로 시작됨
				"The The the The"	// 매치1: The {0~3}
		};
		//─────────────────────────────────────────
		title = "$ : 문자열의 마지막이 앞의 이 문자열로 마무리 됨";
		regex = "Man$"; // Man 으로 끝나는 문자열 패텬
		arrInput = new String[] {
				"SuperMan",
				"AquaMan",
				"WonderWoman",	// man 이 소문자라 매칭 안됨
				"WonderWoMan",	// Man 을 대문자로 하면 매칭 됨
				"PostMan "		// Man 뒤에 공백이 존재하기 때문에 매칭되지 않음
				
		};

		//─────────────────────────────────────────
		title = "^표현식$ : 정확하게 전체패턴매칭되는 문자열";
		regex = "^Su...Man$"; // 표현식으로 시작해서 표현식으로 끝나야 하므로 정확하게 전체 패턴 매칭이 되어야 한다.
		arrInput = new String[] {
				"SuperMan",
				"Super Man",	// 가운데 ...이 세글자여야 하는데 네글자라 매칭 안됨
				" SuperMan",	// 앞에 공백이 있어서 매칭 안됨
				"SuperMan ",	// 뒤에 공백이 있어서 매칭 안됨
				"superman",		// 소문자라 매칭 안됨
				"SugarMan"
		};
				
		//─────────────────────────────────────────
		title = " . : 어떤 문자든지 임의의 '한문자'를 말한다.꼭 하나의 문자와 매칭";
		regex = "x.z";
		arrInput = new String[] {
				"xyz",
				"xxzdfdk",
				"aa10x9zbxbz",
				"xz",
				"90x zxx_zdf",  // 공백도 하나의 문자다! 매칭된다
				"xbz",				
				"xyyz",
				"xzyx xzyzyxxx yxyzxxyzx xyzxxyzxy xyzx yxzxyzxy"
		};
		//─────────────────────────────────────────
		title = " * : 바로 앞의 문자가 없거나 한개 이상의 경우를 매칭";
		regex = "ab*"; // a 로 시작하고 b 는 없어도 되고 한 개 이상 여러개 나오는 경우도 된다.
		arrInput = new String[] {
				"a",
				"abc",
				"ab",
				"abbbaaaabababbab",
				"bbba",
				"cdef"
		};
		
		//─────────────────────────────────────────
		title = " + : 바로 앞의 문자를 나타내면 꼭 한개 혹은 그 이상을 매칭";
		regex = "ab+"; // a 로 시작하고 b 는 반드시 한 개 이상 여러개 나와야 한다.
		arrInput = new String[] {
				"a",
				"abc",
				"ab",
				"abbbaaaabababbab",
				"bbba",
				"cdef"
		};
		
		//─────────────────────────────────────────
		title = " ? : 바로 앞의 문자가 한개 있거나 없는것을 매칭";
		regex = "ab?"; // a 로 시작하고 b 가 한 개 존재하거나 없으면 매칭 된다.
		arrInput = new String[] {
				"a",
				"abc",
				"kkabcc",
				"abbbaaaabababbab",
				"bbba"
		};

		//─────────────────────────────────────────
		title = " [] : 안에 존재하는 문자들중 한 문자만을 매칭";
		regex = "[abc]"; // a 또는 b 또는 c 중에 한 문자에 매칭
		arrInput = new String[] {
				"able",
				"bible",
				"cable",
				"xenosys",
		};
		
		regex = "[abc]+";
		regex = "[a-z]+";	// a ~ z 까지 문자 한 개 이상
		arrInput = new String[] {
				"abc100",
				"abcDefGHIUJ-KLM123opQrstuz"
			};

		regex = "[a-z||A-Z]+";	// a ~ z 또는 A ~ Z 까지 문자 한 개 이상
		regex = "[a-zA-Z]+";	// a ~ z 또는 A ~ Z 까지 문자 한 개 이상
		regex = "[a-zA-Z0-9]+";
		regex = "[a-z||A-Z||0-9||-]+";
		regex = "[a-zA-Z0-9-]+";	// a~z 또는 A~Z 또는 0~9 또는 -(하이픈) 포함
		
		arrInput = new String[] {
				"23",
				"0",
				"-10",
				"012"
		};
		regex = "^[1-9][0-9]*$";	// 자연수 에 대한 정규 표현식
		regex = "^-[0-9]*$";		// 음수 에 대한 정규 표현식


		//─────────────────────────────────────────
		title = " {} : 앞에 있는 문자나 문자열의 등장개수를 정함";
		regex = "ab{2}"; // a 로 시작되고 b가 반드시 2개 있어야 한다.
		arrInput = new String[] {
				"abb",
				"abbb",
				"abbbabbbbbbbbabaabab",
		};
		
		regex = "ab{2,}";	// a 로 시작하고 b 의 개수가 2개 '이상' 있어야 한다.
		regex = "ab{3,5}";	// a 로 시작하고 b 의 개수가 3개 '이상' 최대 5개 까지 매칭
//		regex = "ab{3, 5}";	// PatternSyntaxException, 정규표현식은 붙여서 써야한다.
		
		//─────────────────────────────────────────
		title = " () : ()안에 있는 글자들을 그룹화 ";
		regex = "a(bc)*"; // a로 시작하고 bc가 0개 이상 패턴으로 있으면 매칭
		arrInput = new String[] {
				"abc",
				"abcbcbbca",
				"abcabcabc",

		};
		
		//─────────────────────────────────────────
		title = " | : OR 연산자  역할";
		regex = "a|b"; // a 또는 b 둘 중 하나라도 있으면 매칭
		arrInput = new String[] {
				"a",
				"b",
				"ab",
				"xyz",
				"abcacbccbacbcaccbacbcabcbcbabcacbacabca"
		};
		regex = "(a|b)+";
		
		//─────────────────────────────────────────
		title = "(?i)  : 대소문자 구분안하고 매칭 ";  // 타 언어 정규표현식과 다름
		regex = "(?i)abc"; // 대소문자 구분 안하고 매칭
		arrInput = new String[] {
				"abc",
				"Abc",
				"ABC"
		};
		
		//─────────────────────────────────────────
		title = "\\s : 공백,  \\S : 공백아닌 문자";
		regex = "\\s+"; // 공백(스페이스, 줄바꿈, 탭 포함)이 한 개 이상인 문자 매칭
		arrInput = new String[] {
				"Hello My World",
				"He \tllo My World",
				"\n\t Hello My World\n\n",
		};
		
		regex = "\\S+";
		
		//─────────────────────────────────────────
		title = "\\w : 알파벳이나 숫자, \\W 알파벳이나 숫자를 제외한 문자";
		regex = "\\w+"; // 알파벳이나 숫자가 하나 이상
		arrInput = new String[] {
				"This is 2020-03-23 !!",
		};
		
		regex = "\\W+";

		//─────────────────────────────────────────
		title = "\\d : [0-9] 숫자, \\D 숫자를 제외한 모든 문자";
		regex = "\\d+"; // TODO
		arrInput = new String[] {
				"This is 2020-03-23 !!",
		};
		
		regex = "\\D+";
		
		
		//─────────────────────────────────────────
		title = "escaped character 매칭 시키기";
//		regex = ".+"; // TODO
		regex = "[.]+"; // escaped character 를 매칭시키려면  [, ] 를 넣는다
		arrInput = new String[] {
				"My name is ..."
		};
		/*
		*/
		//*****************************************
		// 패턴매칭 수행
		System.out.println(title);
		regExpTest(regex, arrInput);

		System.out.println("프로그램 종료");
	} // end main()
	
	// 도우미 함수
	public static void regExpTest(String regex, String [] arrInput) {
		for(String input : arrInput) regExpTest(regex, input);
	}
	
	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);
		
		Matcher matcher = Pattern.compile(regex).matcher(input);
		int groupCount = matcher.groupCount();  // 그룹 개수
		
		int matchCount = 0;		
		while(matcher.find()) {
			matchCount++;
			System.out.println("    매치" + matchCount + ": " + matcher.group() + " {" + matcher.start() + "~" + matcher.end() + "}");
			
			// 그룹이 있으면 group별 출력
			if(groupCount > 0) {
				for(int i = 0; i <= groupCount; i++) {	 // i 범위 주목!	
					System.out.printf("\t group(%d): %s {%d~%d}\n",
							i, matcher.group(i), matcher.start(i), matcher.end(i));
				}
			}
			
		} // end while
		if(matchCount == 0) System.out.println("   Ⅹ매치 없슴Ⅹ");
		System.out.println();
	} // end regExpTest()

} // end class
