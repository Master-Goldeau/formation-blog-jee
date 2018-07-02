package fr.gtm.blog.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Classe d'entité POJO représentant une donnée d'article de blog.
 */
public class Article implements Entity, Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String title;

	private String description;

	@JsonProperty(access=Access.WRITE_ONLY)
	//Permet par exemple de ne pas renvoyer un mot de passe reçu par le front.
	
	private Author author;

	/**
	 * Constructeur par défaut
	 */
	public Article() {
	}

	/**
	 * Constructeur avec arguments pour faciliter la création.
	 * 
	 * @param title son titre.
	 * @param description son paragraphe de description.
	 */
	public Article(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
