package fr.gtm.blog.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.gtm.blog.business.ArticleService;
import fr.gtm.blog.domain.Article;

@Controller
public class IndexController {

	@Autowired
	public ArticleService service;
	
	@RequestMapping({"/index","/articles"})
	public ModelAndView index() {
		List<Article> listArticle = new ArrayList<Article>();
		listArticle = this.service.getList();
		final ModelAndView mav = new ModelAndView("index");
		return mav.addObject("listArticle", listArticle);
	}
	
	@RequestMapping("/manage")
	public ModelAndView article() {
		final ModelAndView mav = new ModelAndView("article");
		return mav;
	}
	
	@PostMapping("/manage")
	public ModelAndView submit(@RequestParam ("title") String title, @RequestParam ("descr") String description) {
		this.service.create(new Article(title, description));
		return this.index();		
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteArticle(Integer id) {
		this.service.delete(id);
		return this.index();	
	}
}
