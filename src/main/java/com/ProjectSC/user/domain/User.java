package com.ProjectSC.user.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {
	private int id;
	private String loginId;
	private String email;
	private String password;
	private String name;
	private String phoneNumber;
	private Date createdAt;
	private Date updatedAt;
}
