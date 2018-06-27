package fr.gtm.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.blog.domain.Article;

@Repository

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
