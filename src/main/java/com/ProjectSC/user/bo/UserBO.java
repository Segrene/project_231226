package com.ProjectSC.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectSC.user.domain.User;
import com.ProjectSC.user.domain.UserInfo;
import com.ProjectSC.user.mapper.UserMapper;

@Service
public class UserBO {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserInfo GetUserSByLoginId(String loginId) {
		return userMapper.selectUserSByLoginId(loginId);
	}

	public Integer addUser(String loginId, String email, String hashedPassword, String name, String phoneNumber) {
		Integer userId = userMapper.insertUser(loginId, email, hashedPassword, name, phoneNumber);
		return userId;
	}

	public User getUserByLoginIdAndPassword(String loginId, String hashedPassword) {
		return userMapper.selectUserByLoginIdAndPassword(loginId, hashedPassword);
	}

	public UserInfo getUserSById(int userId) {
		return userMapper.selectUserSById(userId);
	}
}
