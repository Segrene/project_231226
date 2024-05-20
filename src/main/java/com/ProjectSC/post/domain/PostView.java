package com.ProjectSC.post.domain;

import com.ProjectSC.user.domain.UserInfo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class PostView {
	private Post post;
	private UserInfo user;
}
