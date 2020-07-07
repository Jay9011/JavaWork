package com.mvn.junittest17;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest 
{
	private App app;
	
	@Before
	public void initTest2() {
		app = new App();
	}

	// 실습1
    @Test
    public void test1() {
    	int[][] arrData = 
    		{
    			{1, 3, 2, 4, 5},
    		    {8, 3, 5, 2, 7},
    		    {6, 4, 9, 1, 3},
    		    {1, 6, 8, 4, 3},
    		    {9, 4, 2, 1, 5}
    		};
    	
    	for (int i = 0; i < arrData.length; i++) {
    		System.out.println("arr" + i + " 전 : " + Arrays.toString(arrData[i]));
    		// sortArr 실행
    		app.sortArr(arrData[i]);
    		// sort 결과를 하나하나 앞에서부터 확인하는 과정
    		for (int j = 0; j < arrData[i].length - 1; j++) {
    			// 만약 j 가 j + 1 보다 크다면 실패!
    			if(arrData[i][j] > arrData[i][j + 1]) {
    				fail();
    			} // end if
			} // end for
    		System.out.println("arr" + i + " 후 : " + Arrays.toString(arrData[i]));
		} // end for
    } // end test1()
    
    // 실습2
    @BeforeClass
    public static void beforeTest2() {
    	String path = System.getProperty("user.dir") +
				File.separator +
				"TEST";	// "test"
		System.out.println("폴더 경로 : " + path);
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdir();
		} // end if
    } // beforeTest2()
    
    @Test
    public void test2() {
    	int[][] arrData = 
    		{
    			{1, 3, 2, 4, 5},
    		    {8, 3, 5, 2, 7},
    		    {6, 4, 9, 1, 3},
    		};
    	StringBuffer log = new StringBuffer();
    	
    	for (int i = 0; i < arrData.length; i++) {
    		int maxNum = Integer.MIN_VALUE;
    		int minNum = Integer.MAX_VALUE;
        	for (int j = 0; j < arrData[i].length; j++) {
    			if(maxNum < arrData[i][j]) maxNum = arrData[i][j];
    			if(minNum > arrData[i][j]) minNum = arrData[i][j];
    		} // end for
        	int maxResult = app.max(arrData[i]);
        	int minResult = app.min(arrData[i]);
        	assertEquals(maxResult, maxNum);
        	log.append("arr" + i + " 최대값 : " + maxResult + "\n");
        	assertEquals(minResult, minNum);
        	log.append("arr" + i + " 최소값 : " + minResult + "\n");
		} // end for
    	
    	String path = System.getProperty("user.dir") +
				File.separator + "TEST" + File.separator +  
				"report.txt";	// report.txt
		System.out.println("파일 경로 : " + path);
		File f = new File(path);
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(f, false);
			writer.write(log.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer != null) writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
		} // end try-catch-finally
    	
    } // end test2()
    
} // end AppTest
