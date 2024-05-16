package com.ProjectSC.post.domain;

import java.util.Date;

import com.ProjectSC.user.domain.UserSimple;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class PostInfo {
	private int id;
	private int userId;
	private int category;
	private Integer subCategory;
	private String title;
	private Integer related;
	private Date createdAt;
	private Date updatedAt;
	private UserSimple user;
}
