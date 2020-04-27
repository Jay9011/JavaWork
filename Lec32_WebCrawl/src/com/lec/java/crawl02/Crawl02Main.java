package com.lec.java.crawl02;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이트 인기 검색어");
		
		// https://www.nate.com
		// 5개
		String url = "https://www.nate.com";
		Element element;
		Elements elements;
		
		Response response = Jsoup.connect(url).execute();
//		System.out.println(response.statusCode());

		Document doc = response.parse();
		
//		System.out.println(doc.outerHtml());
		
		elements = doc.select(".search_keyword dd a");
		System.out.println(elements.size());
		
		for (Element e : elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		System.out.println("\n프로그램 종료");
	}

}
