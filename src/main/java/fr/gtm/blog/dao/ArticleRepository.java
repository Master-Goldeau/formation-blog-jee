package fr.gtm.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.blog.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	// List<Article> findByTitleContains(String search);
}
