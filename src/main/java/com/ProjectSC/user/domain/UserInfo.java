package com.ProjectSC.user.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserInfo {
	private int id;
	private String loginId;
	private String email;
	private String imagePath;
	private Date createdAt;
}
