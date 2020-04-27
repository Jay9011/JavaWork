package practice;

//country is not visible 오류
// 이유 : 22번째 country가 다른 Class에서 접근제한자가 private 로 선언되었기 때문에
//      다른 Class에서 사용할 수 없게 선언되었다.
// 해결 방법 1. Money에서 선언된 country 를 public 이나 default 로 바꾼다. 
// 해결 방법 2. contry의 접근제한자를 private로 하고 싶다면 country 를 받아올 수 있도록 따로 getter 를 만들어 주어야 한다.
class Money {
	public String country = "Canada";

	public String getC() {
		return country;
	}
}
class Yen extends Money {
	public String getC() {
		return super.country;	// country is not visible 오류
								// 이유 : 22번째 country가 다른 Class에서 접근제한자가 private 로 선언되었기 때문에
								//      다른 Class에서 사용할 수 없게 선언되었다.
	}
}								// 해결 방법 1. Money에서 선언된 country 를 public 이나 default 로 바꾼다. 
								// 해결 방법 2. contry의 접근제한자를 private로 하고 싶다면 country 를 받아올 수 있도록 따로 getter 를 만들어 주어야 한다.
public class Main extends Money {
	public String getC(int x) {
		return super.getC();
	}
	public static void main(String[] args) {
		System.out.print(new Yen().getC() + " " + new Main().getC());
	}

}