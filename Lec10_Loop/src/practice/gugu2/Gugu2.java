package practice.gugu2;

import java.util.Iterator;

public class Gugu2 {

	public static void main(String[] args) {
//		2 x 1 = 2		3 x 1 = 3		4 x 1 = 4
//		2 x 2 = 4		3 x 2 = 6		4 x 2 = 8
//			.				.				.
//			.				.				.
//			.
//
//		5 x 1 = 5 		6 x 1 = 6		7 x 1 = 7	
//			.				.				.
//			.				.				.
//			.
//		8 x 9 = 72     9 x 9 = 81
//			.				.
//			.				.
		
		int dan = 1;
		int i = 2;
		while (i <= 9) {
			for (int j = 1; j <= 9; j++) {
				for (dan = i; dan <= i + 2 && dan < 10; dan++) {
					System.out.print(dan + " X " + j + " = " + (dan * j) + "\t");
				} // end for // 한 줄 곱셈 종료
				System.out.println();
			} // end for // i X 9 까지 완료
			i += 3;
			System.out.println();
		} // end while // 9단 종료
		
		/*
		while (dan <= 9) {
			for (int i = 1; i <= 9; i++) {
				int count = 0;
				while (count < 3) {
					count++;
					dan++;
					if (dan >= 10)
						continue;
					System.out.print(dan + " X " + i + " = " + (dan * i) + "\t");
				} // end while
				System.out.println();
				if (i == 9)
					break;
				dan -= count;
			} // end for
			System.out.println();
		} // end while

		System.out.println("==============================================");
*/
//		i x j = 2		i+1 x j = 3		i+2 x j = 4
//		i x j+1 = 4		i+1 x j+1 = 6	i+2 x j+1 = 8
//			.				.				.
//			.				.				.
//			.
//
//		(i+3) x j = 5 	(i+3)+1 x j = 6		(i+3)+2 x j = 7	
//			.				.				.
//			.				.				.
//			.				.				.
//		8 x 9 = 72     9 x 9 = 81
//			.				.
//			.				.


	} // end main()

} // end class
