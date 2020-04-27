package com.lec.java.file17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 	1. URL : 웹 상의 주소, 
 * 	2. HttpURLConnection : 웹연결
 * 		URLConnection
 * 		 └─ HttpURLConnection
 * 
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class File17Main {

	public static void main(String[] args) {
		System.out.println("웹데이터 가져오기(텍스트)");
		
		String url = "https://apis.naver.com/mobile_main/srchrank/srchrank?frm=main&ag=30s&gr=1&ma=-2&si=0&en=0&sp=0";
		StringBuffer sb = readFromUrl(url);
//		System.out.println(sb.toString().substring(0, 200));
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
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

} // end class
