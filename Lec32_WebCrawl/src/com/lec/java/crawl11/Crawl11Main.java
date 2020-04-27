package com.lec.java.crawl11;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * XML, JSON 파싱 연습
 * 
 * ■서울시 지하철 역사 정보
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * 
 * XML 버젼
 * http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울
 * 
 * JSON 버젼
 * http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울
 * 
 */
public class Crawl11Main {
	
	public static final String REQ_SERVICE = "stationInfo";	// TODO
	public static final String API_KEY = "46476a646a74726f38336a6b78774b"; // key 값 
	
	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철 역사(Station) 정보");
		
		String url_address;
		StringBuffer sb;	// response 받은 텍스트
		Scanner sc = new Scanner(System.in);

		// TODO : API url 에 필요한 parameter 들
//		int startIndex	= 0;
//		int endIndex = 5;
//		String statnNm = "왕십리";
		System.out.print("찾고 싶은 역 이름 : ");
		String statnNm = sc.next().trim();
		if(statnNm.charAt(statnNm.length() - 1) == '역') {
			statnNm = statnNm.substring(0, statnNm.length() - 1);
		}
		
		
		System.out.print("찾고 싶은 역 개수 (공백 구분) : ");
		int startIndex	= sc.nextInt();
		int endIndex = sc.nextInt();
		
		sc.close();
		
		System.out.println("---XML 파싱 ---");
		// TODO
		url_address = buildUrlAddress("xml", startIndex, endIndex, statnNm);
		sb = readFromUrl(url_address);
		parseXML(sb.toString());
		
		
		System.out.println("---JSON 파싱 ---");
		// TODO
		url_address = buildUrlAddress("json", startIndex, endIndex, statnNm);
		sb = readFromUrl(url_address);
		parseJson(sb.toString());
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

	// TODO
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String statnNm) throws IOException {
		String url_address = String.format("http://swopenapi.seoul.go.kr/api/subway/46476a646a74726f38336a6b78774b/%s/stationInfo/%d/%d/%s", 
								reqType, startIndex, endIndex, URLEncoder.encode(statnNm, "utf-8"));
		
		return url_address;
	}
	
	/**
	 * 
	 * @param urlAddress : 주어진 url 주소
	 * @return 서버로부터 받은 텍스트데이터(HTML) 리턴
	 * 
	 */
	public static StringBuffer readFromUrl(String urlAddress) {
		
		StringBuffer sb = new StringBuffer();	// response 받은 데이터 담을 객체
		
		URL url = null;	// java.net.URL
		HttpURLConnection conn = null;	// java.net.HttpURLConnection
		
		InputStream in = null;
		InputStreamReader reader = null;	// byte 스트림 --> 문자기반 Reader
		BufferedReader br = null;
		
		char[] buf = new char[512];	// 문자용 버퍼
		
		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection
		
		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection)url.openConnection();	// Connection 객체 생성
			
			if(conn != null) {
				conn.setConnectTimeout(2000);	// 2초 이내에 '연결' 이 수립안되면
									// java.net.SocketTimeoutException 발생
				
				conn.setRequestMethod("GET");	// GET 방식 request
				// GET, POST, ...
				
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false);
				
				System.out.println("request 시작 : " + urlAddress);
				conn.connect();		// request 발생 --> 이후 response 받을때까지 delay
				System.out.println("response 완료");
				
				// response 받은 후 가장 먼저 response code 값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				
				if(responseCode == HttpURLConnection.HTTP_OK) {
					
					in = conn.getInputStream();	// InputStream <- HttpURLConnection
					reader = new InputStreamReader(in, "utf-8");	// InputStreamReader <- InputStream  
					br = new BufferedReader(reader);	// BufferedReader <- InputStreamReader
					
					int cnt;	// 읽은 글자 개수
					while((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt);	// response 받은 텍스트를 StringBuffer 에 추가
					}
					
				} else {
					System.out.println("response 실패");
					return null;
				}
			} else {
				System.out.println("conn null");
				return null;
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(conn != null) conn.disconnect();		// 작업 끝나고 Connection 해제
		}
		
		return sb; 
	}
	
	public static void parseXML(String xmlText) {
		
		// TODO
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));
			Document dom = dBuilder.parse(in);
			Element docElement = dom.getDocumentElement();
			
//			Element docElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xmlText.getBytes("utf-8"))).getDocumentElement();
			
			docElement.normalize();
			
			NodeList list = docElement.getElementsByTagName("row");
			
			System.out.println("<row> 의 개수 : " + list.getLength());
			System.out.println();
			
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				
				if(node.getNodeType() != node.ELEMENT_NODE) continue;
				
				Element element = (Element) node;
				
				String rowNum = 
						element.getElementsByTagName("rowNum").item(0).getChildNodes().item(0).getNodeValue().trim();
				String statnNm =
						element.getElementsByTagName("statnNm").item(0).getChildNodes().item(0).getNodeValue().trim();
				String subwayId =
						element.getElementsByTagName("subwayId").item(0).getChildNodes().item(0).getNodeValue().trim();
				String subwayNm =
						element.getElementsByTagName("subwayNm").item(0).getChildNodes().item(0).getNodeValue().trim();
				
				System.out.println(rowNum + ": " + statnNm + "역 " + subwayId + " " + subwayNm);
			}
			System.out.println();
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end parseXML()
	
	public static void parseJson(String jsonText) {
		
		// TODO
		JSONObject JObject = new JSONObject(jsonText);
		JSONArray JArray = JObject.getJSONArray("stationList");

		System.out.println("station의 개수 : " + JArray.length());
		System.out.println();
		
		for (int i = 0; i < JArray.length(); i++) {
			JSONObject station = JArray.getJSONObject(i);
			
			int rowNum = station.getInt("rowNum"); 
			String statnNm = station.getString("statnNm");
			int subwayId = station.getInt("subwayId");
			String subwayNm = station.getString("subwayNm");
			
			System.out.println(rowNum + ": " + statnNm + "역 " + subwayId + " " + subwayNm);
		}
		System.out.println();
	} // end parseJson(String)
	
} // end class
