package fr.gtm.blog.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.blog.domain.Entity;

public abstract class CrudService<ENTITY extends Entity> {

	/**
	 * Une instance de l'implémentation de ArticleRepository (générée par
	 * Spring) sera injectée en valeur de "repo" grâce à cette annotation.
	 */
	@Autowired
	protected JpaRepository<ENTITY, Integer> repo;

	/**
	 * Fonction permettant de factoriser les appels à repo.save(..).
	 * 
	 * @param entity l'article à persister pour création ou mise à jour.
	 * @return Article l'article modifié et validé par la BDD.
	 */
	protected ENTITY save(ENTITY entity) {
		return this.repo.save(entity);
	}

	/**
	 * Créer et enregister un nouvel article.
	 * 
	 * @param title le titre du nouvel article.
	 * @param description sa description associée.
	 * @return Article l'article créé avec son identifiant rempli.
	 */
	public ENTITY create(ENTITY entity) {
		return this.save(entity);
	}

	/**
	 * Récupération de la liste des article depuis la persistence.
	 * 
	 * @return List<Article> tous les articles en BDD.
	 */
	public List<ENTITY> getList() {
		return this.repo.findAll();
	}

	public ENTITY read(Integer id) {
		ENTITY result = null;
		final Optional<ENTITY> wrapper = this.repo.findById(id);
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
	public void delete(Integer id) {
		this.repo.deleteById(id);
	}

	/**
	 * Mise à jour d'un article existant en BDD.
	 * 
	 * @param entity l'article à mettre à jour avec id rempli.
	 * @return Article l'article mis à jour depuis la BDD.
	 */
	public ENTITY edit(ENTITY entity) {
		if (entity.getId() == null) {
			throw new IllegalArgumentException(
					"Cannot update an article without its id.");
		}
		return this.save(entity);
	}

}