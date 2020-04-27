package com.lec.java.access03;

import com.lec.java.access04.TestPublic2;

// 다른 패키지의 (default) 클래스는 import 불가
//import com.lec.java.access04.MyDefault2;	// not visible // 은닉 Class

//import com.lec.java.access04.TestPublic;

// 클래스의 접근 권한 수식어: public, (default)
// 1. public class: 어디에서나 인스턴스 생성이 가능한 클래스
//   (주의) public 클래스의 이름은 .java 파일 이름과 반드시 같아야 함. (.java 파일당 한 개 존재)
// 2. (default) class: 같은 패키지에 있는 클래스들에서만 인스턴스 생성이 가능

//(default) 클래스의 이름은 .java 파일의 이름과 같아야 할 필요는 없다.

public class Access03Main {

	public static void main(String[] args) {
		System.out.println("public, default 클래스");
		
		TestPublic t1 = new TestPublic();
		
		// 같은 패키지에 있는 클래스에서는 생성(사용) 가능
		MyDefault t2 = new MyDefault();
		
		// 다른 패키지에 있는 public 클래스
		// --> 인스턴스 생성 가능!
		TestPublic2 t3 = new TestPublic2();
		
		// 다른 패키지에 있는 default 클래스
		// --> 인스턴스 생성 불가...
//		MyDefault2 t4;
		
		// 다른 패키지의 클래스와 동일 이름의 클래스가 충돌된다면?
		com.lec.java.access04.TestPublic t11	// 풀네임을 써서 사용해야 한다.
			= new com.lec.java.access04.TestPublic();
		// 하지만 애초에 이렇게 프로그래밍 하지 않도록 Class명을 겹치지 않도록 해준다.
		

		
	} // end main()

} // end class Access05Main










