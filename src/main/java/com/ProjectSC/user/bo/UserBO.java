package com.ProjectSC.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectSC.user.domain.User;
import com.ProjectSC.user.domain.UserSimple;
import com.ProjectSC.user.mapper.UserMapper;

@Service
public class UserBO {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserSimple GetUserSByLoginId(String loginId) {
		return userMapper.selectUserSByLoginId(loginId);
	}

	public Integer addUser(String loginId, String email, String hashedPassword, String name, String phoneNumber) {
		Integer userId = userMapper.insertUser(loginId, email, hashedPassword, name, phoneNumber);
		return userId;
	}

	public User getUserByLoginIdAndPassword(String loginId, String hashedPassword) {
		return userMapper.selectUserByLoginIdAndPassword(loginId, hashedPassword);
	}
}
