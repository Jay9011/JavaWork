package practice2;

import java.io.IOException;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

public class Main {

public static void main(String[] args) throws IOException {

String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";

Elements elements;

Document doc = Jsoup.connect(url).execute().parse();

elements = doc.select("#assistant div:nth-child(1) ul.r_ranking li a");

for (Element e : elements) {

System.out.println(e.text().trim());

}

System.out.println("\n프로그램 종료");

}

}