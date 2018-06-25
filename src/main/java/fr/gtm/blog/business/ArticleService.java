package fr.gtm.blog.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.gtm.blog.domain.Article;

@Service
public class ArticleService {

	private static final List<Article> MOCK_ARTICLES = Collections
			.unmodifiableList(Arrays.asList(
					new Article[] { new Article(0, "Article n°1", "DESCR"),
							new Article(1, "Article n°2", "DESCR"),
							new Article(2, "Article n°3", "DESCR") }));

	private int idCount;
	private final List<Article> articles;

	public ArticleService(int idCount) {
		this.idCount = idCount;
		this.articles = new ArrayList<>();
		// FIXME: A supprimer lorsque l'accès BDD est implémenté.
		this.articles.addAll(ArticleService.MOCK_ARTICLES);
	}

	public Article create(final String title, final String description) {
		final Article result = new Article();
		result.setId(this.idCount++);
		result.setTitle(title);
		result.setDescription(description);
		this.articles.add(result);
		return result;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void delete(int id) {
		Article toDelete = null;
		for (Article a : this.articles) {
			if (a.getId().equals(id)) {
				toDelete = a;
				break;
			}
		}
		if (toDelete != null) {
			this.articles.remove(toDelete);
		}
	}
}
