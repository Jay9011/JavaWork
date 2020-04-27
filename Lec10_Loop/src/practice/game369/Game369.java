package practice.game369;

public class Game369 {
	public static void main(String[] args) {
		/*
		 * 369게임
		 * 1~100 까지의 자연수를 나열하되,
		 * 10개 단위로 줄바꿈을 하고
		 * 숫자에 3,6,9 중 하나라도 있으면 * 표시를 하기
		 * 
		 * 출력예
		 * 369 게임
		 * 1	2	*	4	5	*	7	8	*	10
		 * 11	12	*	14	15	*	17	18	*	20
		 * 21	22	*	24	25	*	27	28	*	*
		 * *	*	*	*	*	*	*	*	*	40
		 * 41	42	*	44	45	*	47	48	*	50
		 * 51	52	*	54	55	*	57	58	*	*
		 * *	*	*	*	*	*	*	*	*	70
		 * 71	72	*	74	75	*	77	78	*	80
		 * 81	82	*	84	85	*	87	88	*	*
		 * *	*	*	*	*	*	*	*	*	100
		 * 101	102	*	104	105	*	107	108	*	110
		 * 111	112	*	114	115	*	117	118	*	120
		 * 121	122 * 	124	125	*	127	128	*	*
		 * *	*	*	*	*	*	*	*	*	140
		 */

		int num = 1;
		int max = 1324;
		while(num <= max) {
			for (int j = 0; j < 10; j++) {
				int count = num;
				while(true){
					if (count % 10 == 3 || count % 10 == 6 || count % 10 == 9) {
						System.out.print("*\t");
						break;
					}else {
						if(count / 10 > 0) {
							count /= 10;
							continue;
						}else {
							System.out.print(num + "\t");
							break;
						} // end if
					} // end if
				} // end while
				num++;
				if(num > max) break;
			} // end for
			System.out.println();
		}
	}
}
