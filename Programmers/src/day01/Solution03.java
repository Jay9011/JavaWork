package day01;

public class Solution03 {
	
	static int[] answer;
	
	public static void main(String[] args) {
		/*
		 * n=1 0(1)
		 * n=2 001(3)
		 * n=3 001 0 011(7)
		 * n=4 001 0 011 0 001 1 011(15)
		 * 
		 */
		int n = 3;
		answer = new int[(1<<n)-1];
        
        fold(0, answer.length-1, n);
		
	}
	
	public static void fold(int start, int end, int count){
        if(count<1){
            return;
        }
        int mid = (int) Math.round(((start + end) / 2.0));
        int left = (int) Math.round(((start + mid) / 2.0));
        int right = (int) Math.round(((mid + end) / 2.0));
        answer[right] = 1;
        answer[left] = 0;
        fold(start, mid, count-1);
        fold(mid, end, count-1);
    }

}
