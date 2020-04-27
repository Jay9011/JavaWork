package com.lec.java.crawl03;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Daum 실시간 검색어");

		// http://www.daum.net
		// 15개
		String url = "https://www.daum.net";
		Element element;
		Elements elements;

		Response response = Jsoup.connect(url).execute();
		System.out.println(response.statusCode());

		// Document doc = Jsoup.parse(url, "utf-8");
		Document doc = response.parse();

		elements = doc.select("#wrapSearch .slide_favorsch a");
		System.out.println(elements.size());

		for (Element e : elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}

		System.out.println("\n프로그램 종료");
	}
}
