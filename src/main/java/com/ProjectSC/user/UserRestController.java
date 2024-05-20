package com.ProjectSC.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectSC.common.EncryptUtils;
import com.ProjectSC.user.bo.UserBO;
import com.ProjectSC.user.domain.User;
import com.ProjectSC.user.domain.UserInfo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserRestController {
	@Autowired
	private UserBO userBO;
	
	@GetMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId")String loginId) {
		Map<String, Object> result = new HashMap<>();
		UserInfo user = userBO.GetUserSByLoginId(loginId);
		if (user != null) {
			result.put("code", 200);
			result.put("is_duplicated_id", true);
		} else {
			result.put("code", 200);
			result.put("is_duplicated_id", false);
		}
		return result;
	}
	
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(
			@RequestParam("email")String email,
			@RequestParam("loginId")String loginId,
			@RequestParam("password")String password,
			@RequestParam("name")String name,
			@RequestParam("phone")String phoneNumber) {
		Map<String, Object> result = new HashMap<>();
		
		String hashedPassword = EncryptUtils.sha256(password);
		Integer rowCount = userBO.addUser(loginId, email, hashedPassword, name, phoneNumber);
		
		if (rowCount != 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "DB 등록실패");
		}
		
		return result;
	}
	
	@PostMapping("/login")
	public Map<String, Object> login(
			@RequestParam("loginId")String loginId,
			@RequestParam("password")String password,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		
		String hashedPassword = EncryptUtils.sha256(password);
		User user = userBO.getUserByLoginIdAndPassword(loginId, hashedPassword);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userEmail", user.getEmail());
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 300);
			result.put("error_message", "ID 혹은 비밀번호가 틀렸습니다");
		}
		return result;
	}
}
