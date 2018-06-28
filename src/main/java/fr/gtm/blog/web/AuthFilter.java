package fr.gtm.blog.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {
	public static final String SESSION_AUTH = "auth";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		final HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute(SESSION_AUTH) != null) {
			// L'utilisateur est authentifié.
			chain.doFilter(request, response);
		} else {
			// L'utilisateur est inconnu.
			((HttpServletResponse) response).sendError(401,
					"Veuillez vous authentifier");
		}
	}

	@Override
	public void destroy() {
	}

}
