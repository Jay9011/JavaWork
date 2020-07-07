package com.lec.sts18_sercurity.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring-security5 부터는 반.드.시 PasswordEncoder 를 지정해야만 합니다.
 * @author trowe
 */
public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	/**
	 * 주어진 rawPassword 를 인코딩하여 리턴, 일반적으로 SHA-1 혹은 그 이상의 암호화 알고리즘 사용.
	 */
	@Override
	public String encode(CharSequence rawPassword) {
		System.out.println("encoding 전 : " + rawPassword);
		return rawPassword.toString();
	}

	/**
	 * 주어진 rawPassword 와 인코딩 된 encodedPassword 와 동일한지 판정.
	 */
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("matches 수행 : " + rawPassword + "::" + encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
	}

}
