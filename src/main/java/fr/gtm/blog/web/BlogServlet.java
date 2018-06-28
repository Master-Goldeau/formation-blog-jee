package fr.gtm.blog.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Point d'entrée dans l'application par l'URL '/helloworld'. Permet de traiter
 * les requêtes HTTP en fournissant pour chaque demande un objet de réponse.
 */
public class BlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Point d'entrée pour une requête HTTP (<b>method=GET</b>) envoyée par le
	 * client (navigateur). Permet d'afficher un simple "Hello world!".
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Récupération d'un objet permettant d'écrire dans la réponse renvoyée
		// au client.
		final PrintWriter writer = response.getWriter();
		// Ecriture de chaînes de caractères dans le buffer d'un flux
		// représentant le corps de la réponse HTTP.
		writer.append("<html>");
		writer.append("<body>");
		writer.append("<h1>HelloWorld servlet !!</h1>");
		writer.append("</body>");
		writer.append("</html>");
		// Flush permet de vider le buffer en écrivant son contenu dans le flux
		// de la réponse HTTP renvoyée.
		writer.flush();
	}
}
