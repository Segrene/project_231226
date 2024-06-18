package com.ProjectSC.common;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class EncryptUtils {
	public static String sha256(String plain) {
		// salt 생략
		String encData = "";
		// java 기본 해시 함수인 MessageDigest의 경우 thread-safe하지 않기에 구글 guava 라이브러리를 사용
		encData = Hashing.sha256().hashString(plain, StandardCharsets.UTF_8).toString();
		return encData;
	}
}
