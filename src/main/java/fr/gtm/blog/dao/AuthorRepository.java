package fr.gtm.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.blog.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
