package day01;

import java.util.ArrayList;

public class Solution03 {
	
	ArrayList<Integer> nums = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		/*
		 * n=1 0(1)
		 * n=2 001(3)
		 * n=3 001 0 011(7)
		 * n=4 001 0 011 0 001 1 011(15)
		 * 
		 */
		Solution03 s = new Solution03();
		int n = 4;
		
		int[] answer = new int[(int) (Math.pow(2, n)-1)];
		s.stack(n-1);
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = s.nums.get(i);
		}
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
		}
		
	}
	
	public void stack (int n) {

		if (n < 1) {
			nums.add(0);
		} else {
			stack(n);
			
		}
		
	}

}
