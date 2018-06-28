package fr.gtm.blog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.blog.business.ArticleService;

/**
 * Point d'entrée dans l'application par l'URL '/articles'. Permet de traiter
 * les requêtes HTTP en fournissant pour chaque demande un objet de réponse.
 */
public class IndexServlet extends AutowiredServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ArticleService articleService;

	/**
	 * Point d'entrée pour une requête HTTP (<b>method=GET</b>) envoyée par le
	 * client (navigateur), permet d'afficher la liste des articles.
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("listArticle",
				// Accès à l'instance unique de ArticleService.
				this.articleService.getArticles());
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/index.jsp")
				.forward(request, response);
	}
}
