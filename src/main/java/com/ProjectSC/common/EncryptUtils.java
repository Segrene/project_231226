package com.ProjectSC.common;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class EncryptUtils {
	public static String sha256(String plain) {
		// salt 생략
		String encData = "";
		encData = Hashing.sha256().hashString(plain, StandardCharsets.UTF_8).toString();
		return encData;
	}
}
