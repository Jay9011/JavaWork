package com.lec.java.crawl09;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 연습
// 네이버 '검색어'
// 	  블로그
//		- post title
//		- post URL
//		- blog title
//
//	페이징 구현!
public class Crawl09Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 검색, 페이징");
		
		int i = 1;
		boolean check = true;
		while (check) {
			check = crawlNaverBlog("아크투스", i);
			i = i + 10;
		}
		
		System.out.println("\n프로그램 종료");
	} // end main
	
	public static boolean crawlNaverBlog(String search, int page) throws IOException {
		
		Document doc = null;
		Element element = null;
		Elements elements = null;
		
		if(search == null || search.trim().length() == 0 || page < 1) return false;
		
		String url = "https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d";
		url = String.format(url, URLEncoder.encode(search, "UTF-8"), page);
		
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#elThumbnailResultArea .sh_blog_top");
		for (Element e : elements) {
			String postTitle = e.selectFirst(".sh_blog_title").text().trim();
			String postUrl = e.selectFirst(".sh_blog_title").attr("href").trim();
			String blogTitle = e.selectFirst(".inline a").text().trim();
			
			System.out.println(postTitle + "(" + postUrl + ") : " + blogTitle);
		}
		
		if(doc.select("#main_pack > div.paging a.next").size() < 1) return false;
		
		return true;
		
	} // end crawlNaverBlog(String, int)

} // end Class
