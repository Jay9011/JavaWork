package practice.stddev;

public class StdDev {

	public static void main(String[] args) {
		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기
		int[] score = new int[5];
		for (int i = 0; i < score.length; i++) {
			score[i] = (int)(Math.random() * 100) + 1;
			System.out.print(score[i] + " ");
		}
		System.out.println();
		
		System.out.println("평균 : " + calcAvg(score));
		System.out.println("분산 : " + calcVariance(score));
		System.out.println("표준편차 : " + calcStdDev(score));
		

	} // end main
	
	/**
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] num) {
		return (double)calcSum(num) / num.length;
	} // end calcAvg(int[])
	
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[] num) {
		double variance = 0.0;
		double[] deviation = new double[num.length];
		
		for (int i = 0; i < deviation.length; i++) {
			deviation[i] = num[i] - calcAvg(num);
			variance += Math.pow(deviation[i], 2);
		}
		variance = variance / num.length;
		
		return variance;
	} // calcVariance(int[])
	
	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int[] num) {
		return Math.sqrt(calcVariance(num));
	} // calcStdDev(int[])
	
	public static int calcSum(int[] num) {
		int result = 0;
		
		for (int i = 0; i < num.length; i++) {
			result += num[i];
		}
		
		return result;
	} // calcSum(int[])

} // end class
