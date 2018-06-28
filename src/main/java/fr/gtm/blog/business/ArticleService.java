package fr.gtm.blog.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.blog.dao.ArticleRepository;
import fr.gtm.blog.domain.Article;

/**
 * Couche métier de l'application : Gérer les informations des articles,
 * intermédiaire entre la présentation et la persistance.
 */
public class ArticleService {

	/**
	 * Une instance de l'implémentation de ArticleRepository (générée par
	 * Spring) sera injectée en valeur de "repo" grâce à cette annotation.
	 */
	@Autowired
	private ArticleRepository repo;

	/**
	 * Créer et enregister un nouvel article.
	 * 
	 * @param title le titre du nouvel article.
	 * @param description sa description associée.
	 * @return Article l'article créé avec son identifiant rempli.
	 */
	public Article create(final String title, final String description) {
		return this.save(new Article(title, description));
	}

	/**
	 * Récupération de la liste des article depuis la persistence.
	 * 
	 * @return List<Article> tous les articles en BDD.
	 */
	public List<Article> getArticles() {
		return this.repo.findAll();
	}

	public Article read(Integer id) {
		Article result = null;
		final Optional<Article> wrapper = this.repo.findById(id);
		if (wrapper.isPresent()) {
			result = wrapper.get();
		}
		return result;
	}

	/**
	 * Supprime un article.
	 * 
	 * @param id l'identifiant de l'article à supprimer.
	 */
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	/**
	 * Mise à jour d'un article existant en BDD.
	 * 
	 * @param article l'article à mettre à jour avec id rempli.
	 * @return Article l'article mis à jour depuis la BDD.
	 */
	public Article edit(Article article) {
		if (article.getId() == null) {
			throw new IllegalArgumentException(
					"Cannot update an article without its id.");
		}
		return this.save(article);
	}

	/**
	 * Fonction permettant de factoriser les appels à repo.save(..).
	 * 
	 * @param article l'article à persister pour création ou mise à jour.
	 * @return Article l'article modifié et validé par la BDD.
	 */
	private Article save(Article article) {
		return this.repo.save(article);
	}
}
