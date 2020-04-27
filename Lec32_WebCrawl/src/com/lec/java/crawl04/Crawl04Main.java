package com.lec.java.crawl04;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 연관 검색어");
		
		String url = "https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=";
		Document doc;
		Element element;
		Elements elements;
		
		String searchKeyword;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색어를 입력하세요 : ");
		searchKeyword = sc.nextLine();
		
		String encoded = URLEncoder.encode(searchKeyword, "UTF-8");	// 네이버 검색페이지는 UTF-8 로 encoding 해서...
		url += encoded;
		
//		System.out.println(url);
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#nx_related_keywords .lst_relate a");
		
		for (Element e : elements) {
			System.out.println(e.text().trim());
		}
		
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()

} // end Class
