package practice.fibonacci;

/*
 재귀호출 연습:
 
 피보나치 수는 0과 1로 시작하며, 다음 피보나치 수는 바로 앞의 두 피보나치 수의 합이 된다.
n = 0, 1,...에 해당하는 피보나치 수는 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ... 이다.
 */
public class Main {

	public static void main(String[] args) {
		int n = 40;
		// 피보나치 수열 n번째 항까지 출력해보기
		for(int i = 0; i < n; i++) {
			System.out.print(solution(i) + ", ");
		}
		System.out.println();
	}
	
	public static long solution(int n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else return solution(n-1) + solution(n-2);
    }


}
