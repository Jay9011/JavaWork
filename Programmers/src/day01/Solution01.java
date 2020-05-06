package day01;

public class Solution01 {
	public static void main(String[] args) {
		String s = "pPoooyY";

		int p = 0;
		int y = 0;
		s = s.toLowerCase();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'p') {
				p++;
			}else if(c == 'y') {
				y++;
			}
		}
		
		if (p == y) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		System.out.println(s);
	}
}
