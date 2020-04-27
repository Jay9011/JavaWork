package practice.cardcompany;

public class Card {

	// 카드 고유 번호
	private int cardNumber;
	
	// 기본 생성자
	Card() {}
	
	Card(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	protected void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
} // end class
