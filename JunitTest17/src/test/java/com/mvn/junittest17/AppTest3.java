package com.mvn.junittest17;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class AppTest3 {
	
	private App app;
	private String phoneNum;
	private String expected;
	
	@Parameters
	public static Collection<String[]> getTestParameters(){
		return Arrays.asList(new String[][] {
			{"010-1234-1234", "01012341234"},
			{"010-4343-4343", "01043434343"},
			{"010-5252-5252", "01052525252"}
		});
	} // end getTestParameters()
	
	public AppTest3(String phoneNum, String expected) {
		super();
		this.phoneNum = phoneNum;
		this.expected = expected;
	}

	// 실습3
	@Before
	public void beforeTest3() {
		app = new App();
	}
	@Test
	public void test3() {
//		System.out.println(phoneNum + " → " + app.toNumber(phoneNum));
		assertEquals(expected, app.toNumber(phoneNum));
	} // end test3()

} // end AppTest3
