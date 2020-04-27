package practice;

public class Main7 {
	public static void parse(String str) {
		float f = 0;
		try {
			f = Float.parseFloat(str);
		} catch (NumberFormatException nfe) {
			f = 0;
		} finally {
			System.out.println(f);
		}
	}
	public static void main(String[] args) {
		parse("invalid");
	}
}
// 8번째 줄과 10번째 줄에서 찾아갈 수 있는 변수 f 가 선언되어있지 않다.
// 3번째 줄에서 선언된 f 는 해당 지역(바디 { }) 안에서 사용되고 해당 지역을 나가게 되면 사라지기 때문에 바디 밖에서 선언해야 된다.
// 