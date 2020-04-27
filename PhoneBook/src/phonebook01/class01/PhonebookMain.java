package phonebook01.class01;

import java.util.Scanner;

public class PhonebookMain {

	Scanner sc;
	PhonebookModel[] bookData = new PhonebookModel[5];
	
	public static void main(String[] args) {
		PhonebookMain app = new PhonebookMain();
		app.init();	// 초기화
		app.run();	// 실행
		app.exit();	// 종료
		
	} // end main()
	
	// 응용프로그램을 초기화
	public void init() {
		sc = new Scanner(System.in);
	} // end init()
	
	// 응용프로그램 구동
	public void run() {
		System.out.println("전화번호부 v1.0");
		
		while (true) {
			showMenu();	// 메뉴 표시

			int menu = sc.nextInt();	// 메뉴 입력
			sc.nextLine();
			switch (menu) {
			case 1:
				System.out.println("전화번호부를 입력합니다.");
				insertPhoneBook();
				break;

			case 2:
				System.out.println("전화번호부를 열람합니다.");
				ShowPhoneBook();
				break;
				
			case 3:
				System.out.println("프로그램 종료");
				return;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			} // end switch
			
			
		} // end while
		
	} // end run()
	
	// 응용프로그램 종료
	public void exit() {
		sc.close();
	} // end exit()
	
	// 전화번호부 입력
	public void insertPhoneBook() {
		int lastNum = 0;
		// 전화번호부가 다 찼는지 체크
		for (lastNum = 0; lastNum < bookData.length; lastNum++) {
			if(bookData[lastNum] == null) break; 
		}
		// 다 찼으면 입력불가 처리
		if(lastNum >= bookData.length) {
			System.out.println("전화번호부가 가득 찼습니다.");
			System.out.println("더 이상 입력은 불가능합니다.");
			return;
		}
		// 비어있으면 입력
		// 이름, 전화번호, 이메일 입력
		System.out.print("추가할\t이름 : ");
		String name = sc.next();
		System.out.print("\t번호 : ");
		String phoneNum = sc.next();
		System.out.print("\t이메일 : ");
		String email = sc.next();
		// --> PhonebookModel 인스턴스 생성
		bookData[lastNum] = new PhonebookModel(name, phoneNum, email);
		// 배열에 추가
//		bookData[lastNum] = new PhonebookModel();
//		System.out.print("추가할\t이름 : ");
//		bookData[lastNum].setName(sc.next());
//		System.out.print("\t번호 : ");
//		bookData[lastNum].setPhoneNum(sc.next());
//		System.out.print("\t이메일 : ");
//		bookData[lastNum].setEmail(sc.next());
		System.out.println((lastNum + 1) + "번째 전화번호부 추가 성공");
		
		
	} // end insertPhoneBook
	
	// 전화번호부 출력
	public void ShowPhoneBook() {
		int lastNum = 0;
		// 배열 안에 저장된 전화번호부들 출력.
		for (lastNum = 0; lastNum < bookData.length; lastNum++) {
			if(bookData[lastNum] == null) break;
			System.out.println(bookData[lastNum]);
		}
		System.out.println((lastNum + 1) + "개 전화번호부 출력");
	} // end ShowPhoneBook
	
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[1] 입력");
		System.out.println("[2] 열람");
		System.out.println("[3] 종료");
		System.out.println("------------------");
		System.out.print("선택: ");
	} // end showMenu()


} // end class
