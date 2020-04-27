package com.lec.java.crawl01;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * 외부 라이브러리를 사용한 자바 프로젝트
 * 
 * 1. 라이브러리 다운로드
 * 
 * 2. 프로젝트내 (혹은 특정경로)에 라이브러리 저장
 * 
 * 3. 프로젝트의 BuildPath 설정
 * 
 */
/*
 * 	1. https://jsoup.org/	에서 다운로드
 * 	2. 프로젝트에 폴더 만들고 (ex: libs) 라이브러리 복사
 * 	3. 프로젝트 우클릭 - Configure Build Path - Library탭 - Add Jars (혹은 라이브러리 추가) - 추가할 라이브러리 선택
 * 
 */
/*
 * 	네이버 뉴스 캐스트 (상단의 실시간 뉴스)
 * 	
 * 
 */
public class Crawl01Main {
	public static void main(String[] args) throws IOException {
		System.out.println("네이버 뉴스 캐스트 크롤링");
		
		String url;			/** 크롤링할 주소 url */
		Response response;	/** response 객체 (Jsoup.connect(url)의 return값을 저장 할 공간) */
		Document doc;		/** Jsoup 의 Document object model 객체 */
		Element element;	/** HTML 의 element 표현 객체 */
		
		url = "https://www.naver.com";
		response = Jsoup.connect(url).execute();
					/** GET 방식 request 는 다음과 같이 해도 된다. */
					/** Jsoup.connect(url).get(); */
		
		System.out.println("Result - " + response.statusCode() + " : " + response.statusMessage());
/**		request 결과코드
//		200 성공
//		404 url 존재하지 않음
//		500 서버 내부 
//		400 Bad Request : request 문법상의 오류
//		401 권한에러 : 권한 관현 적절한 header 정보가 없는 경우 많이 발생
//		402 권한에러 : 자원에 대한 접근 권한 에러
//		403  권한에러 Forbidden : 파일권한, 읽기권한, SSL, IP, 등...  <--- 웹 크롤링 하다가 은근히 자주 마주치게 되는 에러 */
	
		doc = response.parse();
		
		System.out.println(doc.title());	/** <title> element 크롤링 */
		System.out.println(doc.location());	/** 현재 웹문서의 url */
		
		String outerHtml = doc.outerHtml();
//		System.out.println(outerHtml);
//		System.out.println(outerHtml.substring(0, 200) + "...");
		
		/** Document 나 Element 객체의
		/* select(), selectFirst() 메소드로 특정 element(들)을 추출 */
		System.out.println("[네이버 뉴스 캐스트]");

		element = doc.selectFirst("#news_cast");	/** 검색된 Element 들 중 최초 1개만 Element 로 리턴 */
//		System.out.println(element.outerHtml());
		
		/** 검색된 Element 들이 담겨 있는 Elements 리턴 */
		Elements newsElements = doc.select("#news_cast li.ca_item"); 
		
		/** 복수개 목록 크롤링 할 시, 내가 원하는 '개수'만큼 크롤링 되었는지 우선 확인해보자! */
		System.out.println(newsElements.size());
		for (Element e : newsElements) {
//			System.out.println(e.outerHtml());
			element = e.selectFirst("a");
			System.out.println(element.text());		/** Element 의 text() -> text 들을 묶어서 하나로 리턴 */
			System.out.println(element.attr("href"));
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()
}
