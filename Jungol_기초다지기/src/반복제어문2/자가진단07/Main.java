package 반복제어문2.자가진단07;

public class Main {

	public static void main(String[] args) {
		/*
		 * 	출력 예
		 * 	2 3 4 5 6
		 * 	3 4 5 6 7
		 * 	4 5 6 7 8
		 * 	5 6 7 8 9
		 * 	6 7 8 9 10
		 */
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print(i + j + " ");
			}
			System.out.println();
		}

	}

}
