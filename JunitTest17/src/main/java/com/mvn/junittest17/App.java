package com.mvn.junittest17;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    // 실습1
    public void sortArr(int[] arr) {
    	Arrays.sort(arr);
    }
    
    // 실습2
    public int max(int[] arr) {
    	int maxNum = Integer.MIN_VALUE;
    	for (int i = 0; i < arr.length; i++) {
			if(maxNum < arr[i]) maxNum = arr[i];
		} // end for
    	return maxNum;
    }
    public int min(int[] arr) {
    	int minNum = Integer.MAX_VALUE;
    	for (int i = 0; i < arr.length; i++) {
			if(minNum > arr[i]) minNum = arr[i];
		}
    	return minNum;
    }
    
    // 실습3
    public String toNumber(String str) {
    	String result = "";
    	result = str.replaceAll("[^0-9]", "");
    	return result;
    }
    
} // end App
