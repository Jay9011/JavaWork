package practice.maxwords;

import java.util.Scanner;
import java.util.StringTokenizer;
/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {
	
	// TODO : 필요한 메소드 있으면 추가 작성
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringTokenizer sentences = new StringTokenizer(sc.nextLine(), ".!?", true);
		String text = "";
		int counter = 0;
//		System.out.println(sentences.countTokens());
		while (sentences.hasMoreTokens()) {
			String temp = sentences.nextToken().trim();
			if(counter < count(temp)) {
				text = temp + sentences.nextToken();
				counter = count(temp);
			} // end if // 기존에 저장한 문장보다 더 많은 단어로 구성된 문장이 있다면 문장과 단어 수를 저장.
		} // end while // 저장된 문장(Token)이 없을 때까지 검사
		
		System.out.println("단어의 개수 : " + counter + "개");
		System.out.println(text);
		
		sc.close();
	} // end main()
	
	public static String[] splitSpace(String text) {
		return text.split("\\s+");
	} // end splitSpace(String) // 문장을 단어들로 나눈다.

	public static int count(String text) {
		return splitSpace(text).length;
	} // end count(String) // 단어들의 개수를 구한다.
} // end class
