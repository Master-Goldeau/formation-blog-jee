package fr.gtm.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.blog.business.ArticleService;
import fr.gtm.blog.domain.Article;

@Controller
public class IndexController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping({ "/index", "/articles" })
	public ModelAndView index() {
		// Nouveau mav utilisant al vue index.JSP
		final ModelAndView mav = new ModelAndView("index");
		// Ajout d'une info dans la liste article
		mav.getModel().put("listArticle", this.articleService.getList());
		return mav;
	}
	
	@GetMapping("/update")
	public ModelAndView updateArticle(@RequestParam Integer articleId) {
		final ModelAndView mav = new ModelAndView("article");
		//Charger (put) l'article existant (get Model) dans le formulaire
		//pour précharger le formulaire avec les valeurs de cet article
		mav.getModel().put("modelArticle", this.articleService.read(articleId));
		return mav;			
	}

	@GetMapping("/manage")
	public ModelAndView article() {
		final ModelAndView mav = new ModelAndView("article");
		mav.getModel().put("modelArticle", new Article());
		// l'objet Model permet de transporter des infos entre le controller et la JSP
		return mav;
	}

	@PostMapping({"/manage", "update"})
	// Pour récuperer les formulaires de l'article
	// public ModelAndView submit(@RequestParam ("title") String title,
	// @RequestParam ("descr") String description) {
	// this.service.create(new Article(title, description));
	// return this.index();

	public String validateArticle(@ModelAttribute Article modelArticle) {
		if (modelArticle.getId() == null) {
			this.articleService.create(modelArticle);
		} else {
			this.articleService.edit(modelArticle);
		}
		return "redirect:/articles.html";
	}

	@GetMapping("/delete")
	public String deleteArticle(@RequestParam Integer id) {
		this.articleService.delete(id);
		return "redirect:/";
	}
}
