package com.ProjectSC.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ProjectSC.user.domain.User;
import com.ProjectSC.user.domain.UserSimple;

@Mapper
public interface UserMapper {

	UserSimple selectUserSByLoginId(String loginId);

	Integer insertUser(@Param("loginId")String loginId, @Param("email")String email,
			@Param("password")String hashedPassword, @Param("name")String name,
			@Param("phoneNumber")String phoneNumber);

	User selectUserByLoginIdAndPassword(@Param("loginId")String loginId, @Param("password")String hashedPassword);

	UserSimple selectUserSById(int userId);
}
