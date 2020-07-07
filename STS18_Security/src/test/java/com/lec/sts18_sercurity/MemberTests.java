package com.lec.sts18_sercurity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 스프링에서는 자동으로 클래스 간 여러 의존주입이 발생하기 때문에
 * 다른 클래스에서 작성한 코드들을 사용할 수 있지만,
 * JUnit 은 테스트 케이스 부분만 실행하기 때문에
 * 빈 자동 등록이나 의존주입이 일어나지 않습니다.
 * 따라서! @Service 나 @Mapper 가 붙은 클래스나 인터페이스도 쓰지 못하게 됩니다.
 * 이럴때는
 * @RunWith 와 @ContextConfiguration 을 이용합니다
 * 
 * 위와 같이 하면 JUnit 테스트를 실행할때 
 * @RunWith 의 SpringJUnit4ClassRunner 클래스가 
 * @ContextConfiguration 에 적어 놓은 파일들을 같이 실행시킵니다. 
 * root-context.xml과 security-context.xml을 실행시켜 빈 등록과 의존 주입을 실행시키는 것입니다
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/security-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberTests {

	/**
	 *  자동주입받을 PasswordEncoder 와 DataSource 객체
	 */
	private PasswordEncoder pwencoder;
	private DataSource ds;

	@Autowired
	public void setPwencoder(PasswordEncoder pwencoder) { this.pwencoder = pwencoder; }
	public PasswordEncoder getPwencoder() { return pwencoder; }

	@Autowired
	public void setDs(DataSource ds) { this.ds = ds; }
	public DataSource getDs() { return ds; }

	/**
	 * 테스트용 데이터를 넣을 DB Connection 과 PreparedStatement , SQL 작성
	 */
	Connection conn = null;
	PreparedStatement pstmt = null;

	final String SQL_INSERT_MEMBER = "INSERT INTO tbl_member(userid, userpw, username) VALUES(?, ?, ?)";
	final String SQL_INSERT_AUTH = "INSERT INTO tbl_member_auth(userid, auth) VALUES(?, ?)";

	@Before
	public void initialize() {
		System.out.println("MemberTests 시작");
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try-catch
	} // end initialize()

	@After
	public void finalize() {
		System.out.println("MemberTests 종료");
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} // end try-catch
	} // end finalize()
	
	@Test
	public void testA() {
		System.out.println("testA() 실행");
		
		if(conn == null) return;
		
		int cnt = 0;
		
		String userid = "", userpw = "", username = "";
		
		try {
			pstmt = conn.prepareStatement(SQL_INSERT_MEMBER);
			for(int i = 0; i < 100; i++) {
				userpw = "pw" + i;	// 패스워드 pw0, pw1, ... 생성
				
				// [일반 사용자 : 운영자 : 관리자] 각각 [80 : 10 : 10] 으로 생성
				if(i < 80) {
					userid = "user" + i;
					username = "일반사용자" + i;
				} else if(i < 90) {
					userid = "member" + i;
					username = "회원" + i;
				} else {
					userid = "admin" + i;
					username = "관리자" + i;
				} // end if-else
				
				try {
					pstmt.setString(1, userid);
					/**
					 * PasswordEncoder 의 .encode 를 사용해서 암호화시켜 저장
					 */
					pstmt.setString(2, pwencoder.encode(userpw));
					pstmt.setString(3, username);
					cnt = pstmt.executeUpdate();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} // end try-catch
				
				if(cnt > 0) {
					System.out.println("INSERT_MEMBER 성공]" + userid + ":" + userpw + ":" + username);
				} else {
					System.out.println("INSERT_MEMBER 실패]" + userid + ":" + userpw + ":" + username);
				} // end if-else
			} // end for
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					pstmt = null;
				} // end if
			} catch (Exception e) { 
				e.printStackTrace();
			} // end try-catch
		} // end try-catch-finally
	}
	
	@Test
	public void testB() {
		System.out.println("testB() 실행");
		
		if(conn == null) return;
		
		int cnt = 0;
		String userid = "", auth = "";
		try {
			pstmt = conn.prepareStatement(SQL_INSERT_AUTH);
			for (int i = 0; i < 100; i++) {
					if(i < 80) {
						userid = "user" + i;
						auth = "ROLE_USER";
					} else if(i < 90) {
						userid = "member" + i;
						auth = "ROLE_MEMBER";
					} else {
						userid = "admin" + i;
						auth = "ROLE_ADMIN";
					} // end if-else
					
					try {
						pstmt.setString(1, userid);
						pstmt.setString(2, auth);
						cnt = pstmt.executeUpdate();
						if(cnt > 0) {
							System.out.println("INSERT_AUTH 성공] " + userid + ":" + auth);
						} else {
							System.out.println("INSERT_AUTH 실패] " + userid + ":" + auth);
						} // end if-else
						
						// admin 의 경우 ROLE_MEMBER 도 추가
						if(userid.startsWith("admin")) {
							auth = "ROLE_MEMBER";
							pstmt.setString(1, userid);
							pstmt.setString(2, auth);
							cnt = pstmt.executeUpdate();
							if(cnt > 0) {
								System.out.println("INSERT_AUTH 성공] " + userid + ":" + auth);
							} else {
								System.out.println("INSERT_AUTH 실패] " + userid + ":" + auth);
							} // end if-else
						} // end if
					} catch (Exception e) {
						System.out.println(e.getMessage());
					} // end try-catch
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} // end try-catch
		} // end try-catch-finally
	}
	@Test
	public void testC() {
		System.out.println("testC() 실행");
	}

} // end Test
