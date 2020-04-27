package com.lec.java.crawl07;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl07Main {
	private static final String FILEPATH = "books";

	public static void main(String[] args) throws IOException {
		System.out.println("인터팤 도서 검색결과 페이지");
		String url;
		Scanner sc = new Scanner(System.in);

		System.out.print("검색어를 입력하세요 : ");
		String search = sc.nextLine();
		sc.close();

		Crawl07Main app = new Crawl07Main();
		ArrayList<InfoBook> list = app.crawlInterPark(search);

		// 썸네일 이미지 다운로드 받아서
		// thumb001.jpg ~ thumb020.jpg ...
		
		int fileIndex = 1;
		if(list.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
		}
		for (InfoBook i : list) {
			System.out.println(i);	// 크롤링 정보 출력
			
			// 썸네일 이미지 다운로드
			String fileName = String.format(FILEPATH + File.separator + "thumb%03d.jpg", fileIndex);
			URL imgUrl = new URL(i.getImgUrl());
			
			BufferedImage imgData = ImageIO.read(imgUrl);
			File file = new File(fileName);
			ImageIO.write(imgData, "jpg", file);
			
			System.out.println("  →[" + i.getBookTitle() + "] 표지 이미지가 " + fileName + "로 저장되었습니다.\n");
			
			fileIndex++;
		} // end for
		
		System.out.println("\n프로그램 종료");
	} // end main()

	private ArrayList<InfoBook> crawlInterPark(String search) throws IOException {
		ArrayList<InfoBook> list = new ArrayList<>();

		String url = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query=";
		Document doc;
		Element element;
		Elements elements;
		Elements rowElements;

		// http://book.interpark.com/
		url += URLEncoder.encode(search, "euc-kr");
		doc = Jsoup.connect(url).execute().parse();
		rowElements = doc.select("#bookresult .list_wrap");
		
		for (Element e : rowElements) {
			String bookTitle = e.selectFirst(".tit a").text().trim();
			String detailUrl = e.selectFirst(".tit a").attr("href").trim();
			String imgUrl = e.selectFirst(".bd").attr("src").trim();
			double price = Double.parseDouble(e.selectFirst(".defaultNum").text().trim().replaceAll("\\D", ""));
			
			double discountPrice = 0;
			double discountRate = 0;
			if(e.selectFirst(".nowMoney") == null) {
				discountPrice = price;
			} else {
				String[] discount = e.selectFirst(".nowMoney").text().trim().split("원");
				discountPrice = Double.parseDouble(discount[0].replaceAll("\\D", ""));
				discountRate = Double.parseDouble(discount[1].substring(discount[1].indexOf("(")+1, discount[1].indexOf("%")));
			}
			
			double point = 0;
			double pointRate = 0;
			if(e.selectFirst(".subNum") == null) {
			} else {
				String[] pointFull = e.selectFirst(".subNum").text().trim().split("P");
				point = Double.parseDouble(pointFull[0].replaceAll("\\D", ""));
				pointRate = Double.parseDouble(pointFull[1].substring(pointFull[1].indexOf("(")+1, pointFull[1].indexOf("%")));
			}
			
//			list.add(new InfoBook(bookTitle, price, detailUrl, imgUrl));
			list.add(new InfoBook(bookTitle, price, discountPrice, discountRate, point, pointRate, detailUrl, imgUrl));
		}

		return list;
	}	

} // end Class
