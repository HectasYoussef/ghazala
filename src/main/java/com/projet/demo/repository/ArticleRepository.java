package com.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.demo.model.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> {

}
