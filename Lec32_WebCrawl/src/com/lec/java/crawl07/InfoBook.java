package com.lec.java.crawl07;

public class InfoBook {
	private String bookTitle;		// 책제목
	private double price;			// 책가격
	private double discountPrice;	// 할인가격
	private double discountRate;	// 할인율
	private double point;			// 적립포인트
	private double pointRate;		// 적립률
	private String url;				// 상세페이지 url
	private String imgUrl;			// 썸네일 url

	public InfoBook() {
	}
	
	public InfoBook(String bookTitle, double price, String url, String imgUrl) {
		this.bookTitle = bookTitle;
		this.price = price;
		this.url = url;
		this.imgUrl = imgUrl;
	}

	public InfoBook(String bookTitle, double price, double discountPrice, double discountRate, double point,
			double pointRate, String url, String imgUrl) {
		this.bookTitle = bookTitle;
		this.price = price;
		this.discountPrice = discountPrice;
		this.discountRate = discountRate;
		this.point = point;
		this.pointRate = pointRate;
		this.url = url;
		this.imgUrl = imgUrl;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	@Override
	public String toString() {
		return " [" + bookTitle + "]"
				+ "\n\t 정가 : " + (int)price + "원"
				+ "\n\t 할인가 : " + (int)discountPrice + "원 (" + discountRate +"%▼)"
				+ "\n\t 적립포인트 : " + (int)point + "P (" + pointRate + "%)"
				+ "\n\t바로가기 : " + url
				+ "\n\timg : " + imgUrl;
	}
	
	
}
