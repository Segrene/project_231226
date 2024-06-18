package com.ProjectSC.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ProjectSC.category.bo.CategoryBO;
import com.ProjectSC.category.domain.Category;
import com.ProjectSC.post.bo.PostBO;
import com.ProjectSC.post.domain.PostInfo;
import com.ProjectSC.post.domain.PostView;

@RequestMapping("/post")
@Controller
public class PostController {
	
	@Autowired
	private PostBO postBO;
	@Autowired
	private CategoryBO categoryBO;
	
	@GetMapping({"/board", "/board/{category}"})
	public String postListView(@PathVariable(value="board", required = false) Integer category,
			@RequestParam(value="sub", required = false)Integer sub, 
			Model model) {
		if (category == null) {
			category = 0;
		}
		if (sub == null) {
			sub = 0;
		}
		model.addAttribute("viewName", "post/postList");
		List<PostInfo> postList = postBO.getPostListByCategory(category, sub);
		model.addAttribute("postList", postList);
		model.addAttribute("boardName", categoryBO.getCategory(category));
		model.addAttribute("tabList", categoryBO.getSubCategoryList(category));
		model.addAttribute("tab", categoryBO.getSubCategory(category, sub));
		return "template/layout";
	}
	
	@GetMapping("/postId/{id}")
	public String productDetailView(@PathVariable("id")int id, Model model) {
		model.addAttribute("viewName", "post/post");
		PostView post = postBO.getPostViewById(id);
		model.addAttribute("post", post);
		return "template/layout";
	}
	
	@GetMapping("/postCreate-view")
	public String productRegisterView(Model model) {
		model.addAttribute("viewName", "post/postCreate");
		List<Category> boardList = categoryBO.getCategoryList(1);
		model.addAttribute("boardList", boardList);
		return "template/layout";
	}
}
