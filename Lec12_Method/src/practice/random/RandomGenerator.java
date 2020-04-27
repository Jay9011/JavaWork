package practice.random;

import java.util.Arrays;
import java.util.Random;

/*
 * 실습 - 랜덤 함수
 */
public class RandomGenerator {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(randomize(10, 21, 3)));
		System.out.println(Arrays.toString(randomize(213, 482, 1)));
		System.out.println(Arrays.toString(randomize(-30, 60, 3)));
		
		
		System.out.println(Arrays.toString(randomize(1, 5, 10)));   // 1 부터 5까지의 범위인데 중복되지 않는 10개??  그러면 5개만 생성
		System.out.println(Arrays.toString(randomize(1, 2, 3)));
		
	} // end main
	
	public static int [] randomize(int startNum, int endNum, int count){
		int [] result = new int[count];  // 결
		
		Random randNum = new Random();
		int num = (randNum.nextInt(endNum - startNum + 1) + startNum);	// 두 수의 차이만큼 뽑은 후 startNum 으로 시작위치 조절
		int indexN = 0;
		int checkCnt = 0;
		
		while(true) {
			if(num == result[indexN]) {
				num = (randNum.nextInt(endNum - startNum + 1) + startNum);
				indexN = 0;
				continue;
			} // end if // 같은 숫자가 존재하면 다시 뽑기
			
			if(indexN >= checkCnt) {
				result[indexN] = num;
				checkCnt++;
				if(checkCnt >= result.length || checkCnt >= (endNum - startNum + 1)) break;	// count까지 전부 뽑았다면 종료.
			}else {
				indexN++;
			} // end if // 마지막까지 같은 숫자가 없다면 숫자 넣기, 마지막이 아니면 다음 조사
			
		} // end while
		
		return result;
	} // end randomize()

} // end class
