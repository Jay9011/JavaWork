package practice.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * - 대소문자 구분하지 않기 : The 와 the 는 같은 단어
 * - 2글자 이상만 계수하기
 * - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 * - 공백 짤라내기
 * ex)
 * an : 234
 * the : 314
 * ...
 * 
 * hint]
 * split("\\s+") --> String[]
 * --> StringTokenizer (혹은 정규표현식)
 * --> HashMap<String, Integer> <단어, 빈도수> 사용
 * ───────────────────────────────────────────────────────────
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * ex)
 * 1 the:113개
 * 2 she:95개
 * 3 to:85개
 * ...
 *
 * hint]
 * Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..

public class AliceInWonderland {

	public static void main(String[] args) {
		System.out.println("실습: 단어 발생 빈도");
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();

		String[] words = C.ALICE30.trim().toLowerCase().split("\\s+");
		
		for (int i = 0; i < words.length; i++) {
			StringTokenizer st = new StringTokenizer(words[i], ",.\"\'`!?;:-()[]_");
			while (st.hasMoreElements()) {
				String word = st.nextToken();
				Integer frequency = hmap.get(word);
				if (word.length() > 1) {
					if (frequency == null) {
						hmap.put(word, 1);
					} else {
						hmap.put(word, frequency + 1);
					} // end if // isNull check
				} // end if // word.lengrh check
			} // end while
		} // end for
		
//		Matcher words = Pattern.compile("[a-zA-Z]{2,}").matcher(C.ALICE30.toLowerCase());
//		
//		while(words.find()) {
//			String word = words.group();
//			Integer frequency = hmap.get(word);
//			
//			if(frequency == null) {
//				hmap.put(word, 1);
//			}else {
//				hmap.put(word, frequency + 1);			
//			} // end if (int)
//		}// end while (boolean)
		
		// 결과 출력
		List<WordFreq> show = new ArrayList<WordFreq>();
		for (Map.Entry<String, Integer> m : hmap.entrySet()) {
			show.add(new WordFreq(m.getKey(), m.getValue()));
		} // end for
		Collections.sort(show);
		

		int i = 1;
		for (WordFreq w : show) {
			System.out.printf("%3d. %-14s : %3d 개\n", i, w.word, w.freq);
			i++;
		} // end for

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

class WordFreq implements Comparable<WordFreq> {
	String word;
	int freq;

	public WordFreq(String word, int freq) {
		super();
		this.word = word;
		this.freq = freq;
	} // end WordFreq(String, int) // constructor

	@Override
	public int compareTo(WordFreq o) {
		if (this.freq > o.freq)
			return -1;
		if (this.freq < o.freq)
			return 1;
		return 0;
	} // end compareTo(WordFreq)

	@Override
	public String toString() {
		return this.word + " : " + this.freq + "개 \n";
	} // end toString()
}
