package phonebook04.list;

import java.util.ArrayList;

// CONTROLLER 객체
//	어플리케이션의 동작, 데이터 처리(CRUD), (Business Logic 담당)

public class PhonebookManager implements Pb {
	
	// ArrayList 사용
	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	
	// Singleton 적용
	private PhonebookManager() {}
	private static PhonebookManager instance = null;
	public static PhonebookManager getInstance() {
		if(instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()
	
	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		// 매개변수 검증 : 이름 필수
		if(name.trim().length() == 0 || name == null) {
			throw new PhonebookException("insert() 이름 입력 오류 : ", Pb.ERR_EMPTY_STRING);
		}
		
		PhonebookModel p = new PhonebookModel(name, phoneNum, memo);
		p.setUid(getMaxUid() + 1);
		pbList.add(p);
		
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		PhonebookModel[] pbA = new PhonebookModel[pbList.size()];

//		for (int i = 0; i < pbList.size(); i++) {
//			pbA[i] = pbList.get(i);
//		}
//		
//		return pbA;
		
		return pbList.toArray(new PhonebookModel[pbList.size()]);
	}

	// 특정 uid의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		for (int i = 0; i < pbList.size(); i++) {
			if(pbList.get(i).getUid() == uid) {
				return pbList.get(i);
				
			}
		}
		
		return null;	// 못찾으면 null 리턴
	} // end selectByUid(int)

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		
		// 매개변수 검증
		if (uid < 1 ) {
			throw new PhonebookException("update() uid 오류 : " + uid, Pb.ERR_UID);
		}
		if(name == null || name.trim().length() == 0) {
			throw new PhonebookException("update() 이름 입력 오류 : ", Pb.ERR_EMPTY_STRING);
		}
		
		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if(index < 0) 
			throw new PhonebookException("update() 없는 uid : " + uid, Pb.ERR_UID);
		
//		pbList.set(index, new PhonebookModel(pbList.get(index).getUid(), name, phoneNum, memo, pbList.get(index).getRegDate()));
		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(phoneNum);
		pbList.get(index).setMemo(memo);
		
		return 1;
	}

	@Override
	public int deleteByUid(int uid) {
		
		// 매개변수 검증
		if(uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류 : " + uid, Pb.ERR_UID);;
		
		int index = findIndexByUid(uid);
		if(index < 0)
			throw new PhonebookException("deleteByUid() 없는 uid : " + uid, Pb.ERR_UID);;
		
		pbList.remove(index);
		
		return 1;
	}

	@Override
	public int searchUid() {
		// TODO
		return 0;
	}
	
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;

		if(pbList.size() > 0) {
			int uid = pbList.get((pbList.size() - 1)).getUid();
			if(maxUid < uid) maxUid = uid;
		}
		
//		for (PhonebookModel p : pbList) {
//			if(maxUid < p.getUid()) {
//				maxUid = p.getUid();
//			}
//		}
		
		return maxUid;
	}
	
	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	private int findIndexByUid(int uid) {
		for (int i = 0; i < pbList.size(); i++) {
			if(pbList.get(i).getUid() == uid) return i;
		}
		return -1;
	}

} // end class
// 예외 Class 정의
// 예외가 발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;
	
	public PhonebookException() {
		super("Phonebook 예외 발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage(); 
		return msg;
	}
}
