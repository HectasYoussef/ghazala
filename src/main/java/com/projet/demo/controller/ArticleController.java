package com.projet.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.demo.model.Article;
import com.projet.demo.model.Client;
import com.projet.demo.repository.ArticleRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Api/Article")
public class ArticleController {
 @Autowired private ArticleRepository articleRepo;
 
 
 @GetMapping("/list")
 public List<Article> getAllClients(){
		List<Article> articles= articleRepo.findAll();
		return articles;
 }
 
 @GetMapping(path = "/{id}")
 public Optional<Article> show(@PathVariable(value = "id")Long id) {
	    Optional<Article> articles = articleRepo.findById(id);
	     return articles;
}
 
 @PostMapping("/ajout")
 public Article createClient(@RequestBody Article article) {
		return articleRepo.save(article);
	}
 
 @PutMapping("/{id}")
 public ResponseEntity<Article> update(@RequestBody Article articleRequert, @PathVariable(value = "id")Long id) {
     Optional<Article> article = articleRepo.findById(id);
     if (article.isPresent()) {
    	 article.get().setNom(articleRequert.getNom());
    	 article.get().setPrix_TTC(articleRequert.getPrix_TTC());
    	 article.get().setUpdatedAt(new Date());
    	 articleRepo.save(article.get());
         return ResponseEntity.status(HttpStatus.OK).build();
     }
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
 }
 
 @DeleteMapping("{id}")
 public ResponseEntity<Void> destroy(@PathVariable(value = "id") Long id) {
     Optional<Article> article = articleRepo.findById(id);
     if (article.isPresent()) {
    	 articleRepo.deleteById(id);
         return ResponseEntity.status(HttpStatus.OK).build();
     }
     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
 }




}
