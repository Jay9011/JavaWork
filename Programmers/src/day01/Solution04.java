package day01;

public class Solution04 {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 2, 4 };
		int[] answer = new int[(arr.length > 1) ? arr.length - 1 : 1];
		if (answer.length == 1) {
			answer[0] = -1;
		} else {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			for (int i = 0; i < arr.length - 1; i++) {
				answer[i] = arr[i];
			}
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.print( "[" + answer[i] + "]");
		}
	}
}
