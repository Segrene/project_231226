package com.ProjectSC.post.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectSC.post.domain.PostInfo;
import com.ProjectSC.post.domain.PostView;
import com.ProjectSC.post.mapper.PostMapper;
import com.ProjectSC.user.bo.UserBO;

@Service
public class PostBO {
	
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private UserBO userBO;
	
	public List<PostInfo> getPostListByCategory(int category, int sub) {
		List<PostInfo> postInfoList = new ArrayList<>();
		
		List<PostInfo> postList = new ArrayList<>();
		
		postList = postMapper.selectPostListByCategory(category);
		for (PostInfo post : postList) {
			PostInfo postInfo = new PostInfo();
			post.setUser(userBO.getUserSById(post.getUserId()));
			postInfoList.add(postInfo);
		}
		
		return postInfoList;
	}

	public PostView getPostViewById(int id) {
		return null;
	}

}
