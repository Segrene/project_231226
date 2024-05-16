package com.ProjectSC.post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ProjectSC.post.domain.PostInfo;

@Mapper
public interface PostMapper {

	List<PostInfo> selectPostListByCategory(int category);

}
