package fr.gtm.blog.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Author implements Entity, Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private LocalDate subDate;

	private Address address;

	private List<Article> articles;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getSubDate() {
		return subDate;
	}

	public void setSubDate(LocalDate subDate) {
		this.subDate = subDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
