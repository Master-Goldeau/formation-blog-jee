package fr.gtm.blog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.blog.business.ArticleService;

public class ArticleServlet extends AutowiredServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ArticleService service;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/article.jsp")
				.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Récupérer les paramètres 'title' et 'descr'.
		final String title = request.getParameter("title");
		final String description = request.getParameter("descr");
		this.service.create(title, description);
		response.sendRedirect(
				this.getServletContext().getContextPath() + "/articles");
	}
}
