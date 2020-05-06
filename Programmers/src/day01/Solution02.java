package day01;

public class Solution02 {

	public static void main(String[] args) {
//		String s = "abcde";
		String s = "qwer";
		int i = s.length() / 2;
		if ((s.length() % 2) == 0) {
			System.out.println(s.substring(i-1, i+1));
		} else {
			System.out.println(s.substring(i, i+1));
		}
	}

}
