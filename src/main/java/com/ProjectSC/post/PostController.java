package com.ProjectSC.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProjectSC.post.bo.PostBO;
import com.ProjectSC.post.domain.PostInfo;

@RequestMapping("/post")
@Controller
public class PostController {
	@Autowired
	private PostBO postBO;
	
	@GetMapping({"/board", "/board/{category}"})
	public String postListView(@PathVariable(required = false) Integer category, Model model) {
		if (category == null) {
			category = 0;
		}
		model.addAttribute("viewName", "post/postList");
		List<PostInfo> PostList = postBO.getPostListByCategory(category);
		model.addAttribute("postList", PostList);
		return "template/layout";
	}
}
