package 출력.형성평가04;

public class Main {

	public static void main(String[] args) {
		int kor = 90;
		int mat = 80;
		int eng = 100;
		int sum = kor + mat + eng;
		int avg = (kor + mat + eng) / 3;
		
		System.out.printf("kor %d\n"
				+ "mat %d\n"
				+ "eng %d\n"
				+ "sum %d\n"
				+ "avg %d\n", kor, mat, eng, sum, avg);

	}

}
