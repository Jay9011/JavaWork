package com.lec.java.crawl15;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Crawl15Main {
	/*
	 * XML, JSON 파싱 연습
	 * 
	 * ■서울시 지하철 역사 정보
	 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&
	 * serviceKind=1&currentPageNo=1
	 * 
	 * XML 버젼
	 * http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/
	 * stationInfo/1/5/서울
	 * 
	 * JSON 버젼
	 * http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/
	 * stationInfo/1/5/서울
	 * 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("jackson-databind 연습2");

		URL url = new URL(
				"http://swopenapi.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/%EC%84%9C%EC%9A%B8");

		ObjectMapper mapper = new ObjectMapper();

		StationInfo info = mapper.readValue(url, StationInfo.class);

		for (Station e : info.getStationList()) {

			System.out.println(e.getRowNum() + ": " + e.getStatnNm() + "역 " + e.getSubwayId() + " " + e.getSubwayNm());
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end Class

@JsonIgnoreProperties(ignoreUnknown = true)
class StationInfo {
	private ArrayList<Station> stationList;

	public StationInfo() {
	}

	public StationInfo(ArrayList<Station> stationList) {
		super();
		this.stationList = stationList;
	}

	public ArrayList<Station> getStationList() { return stationList; }

	public void setStationList(ArrayList<Station> stationList) { this.stationList = stationList; }

} // StationInfo

@JsonIgnoreProperties(ignoreUnknown = true)
class Station {
	private int rowNum;
	private String statnNm;
	private String subwayId;
	private String subwayNm;

	public Station() {
	}

	public Station(int rowNum, String statnNm, String subwayId, String subwayNm) {
		super();
		this.rowNum = rowNum;
		this.statnNm = statnNm;
		this.subwayId = subwayId;
		this.subwayNm = subwayNm;
	}

	public int getRowNum() { return rowNum; }

	public void setRowNum(int rowNum) { this.rowNum = rowNum; }

	public String getStatnNm() { return statnNm; }

	public void setStatnNm(String statnNm) { this.statnNm = statnNm; }

	public String getSubwayId() { return subwayId; }

	public void setSubwayId(String subwayId) { this.subwayId = subwayId; }

	public String getSubwayNm() { return subwayNm; }

	public void setSubwayNm(String subwayNm) { this.subwayNm = subwayNm; }

} // Station
