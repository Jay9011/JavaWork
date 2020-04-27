package com.lec.java.file04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* 보조스트림 (filter stream)
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File

Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream

참고 ) 보조스트림 (filter stream)
보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
*/
public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");

		InputStream in = null;		// InputStream 변수 선언
		BufferedInputStream bin = null;
		OutputStream out = null;	// OutputStream 변수 선언
		BufferedOutputStream bout = null;
		
		try {
			// FileInputStream 인스턴스 생성
			in = new FileInputStream("temp/big_text.txt");
			bin = new BufferedInputStream(in);
			
			// FileOutputStream 인스턴스 생성
			out = new FileOutputStream("temp/copy_big_text.txt");
			bout = new BufferedOutputStream(out);
				// 위 파일이 없으면 새로 생성.
				// 기존 파일이 있으면 기존 파일 삭제 후 새로 생성. (덮어쓰기)
			
			int dataRead;
			int bytesCopied = 0;
			
			long startTime = System.currentTimeMillis();	// 현재 시간 저장
			// 파일복사 : 읽기 -> 쓰기
			while(true) {
				// 데이터 읽기: InputStream에 있는 read() 메소드 사용
				// read()는 InputStream 으로부터 
				// 1byte 씩 읽어서 int(4byte) 에 담아 리턴한다
				// [ ... ][ ... ][ ... ][ 1byte ]
				dataRead = bin.read();
				
				if(dataRead == -1) {	// 더 이상 읽을 것이 없으면 read() 는 -1 리턴
					break;
				}
				
				// 데이터 쓰기: OutputStream에 있는 write() 메소드 사용
				// write() 는 
				// int(4byte)에 1byte씩 담아 OutputStream에 쓴다
				// [ ... ][ ... ][ ... ][ 1byte ]
				bout.write(dataRead);
				bytesCopied++;
			}
			long endTime = System.currentTimeMillis();	// 종료 시간 저장
			long elapsedTime = endTime - startTime;		// 경과 시간
			
			System.out.println("읽고 쓴 바이트 : " + bytesCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제
			try {
				if(bout != null) bout.close();
				if(bin != null) bin.close();
				// bin 을 close 하면, bin 을 만든 in 도 같이 close 됨
				// bout 을 close 하면, bout 을 만든 out 도 같이 close 됨
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














