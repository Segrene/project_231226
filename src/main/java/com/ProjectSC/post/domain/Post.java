package com.ProjectSC.post.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Post {
	private int id;
	private int userId;
	private int category;
	private Integer subCategory;
	private String title;
	private String content;
	private Integer related;
	private Date createdAt;
	private Date updatedAt;
	private String categoryName;
	private String subCategoryName;
}
