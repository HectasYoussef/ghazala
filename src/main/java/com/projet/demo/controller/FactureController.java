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

import com.projet.demo.model.Facture;
import com.projet.demo.repository.FactureRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Api/Facture")
public class FactureController {
	@Autowired private FactureRepository factureRepo;
	
	@GetMapping("/list")
    public List<Facture> getAllClients(){
		List<Facture> factures= factureRepo.findAll();
		return factures;
    }
	
	 @GetMapping(path = "/{id}")
	 public Optional<Facture> show(@PathVariable(value = "id")Long id) {
		    Optional<Facture> factures = factureRepo.findById(id);
		     return factures;
		    				     
	 }	 
	 @PostMapping("/ajout")
	 public Facture createClient(@RequestBody Facture facture) {
		       facture.setCreatedAt(new Date());
		       facture.setUpdatedAt(null);
			return factureRepo.save(facture);
		}
	 @PutMapping("/{id}")
	 public ResponseEntity<Facture> update(@RequestBody Facture  factureRequert, @PathVariable(value = "id")Long id) {
	     Optional<Facture> facture = factureRepo.findById(id);
	     if (facture.isPresent()) {
	    	 facture.get().setNumreauFacture(factureRequert.getNumreauFacture());
	    	 facture.get().setMf(factureRequert.getMf());
            facture.get().setClient(factureRequert.getClient());
	    
	    	 facture.get().setUpdatedAt(new Date());
	    	 factureRepo.save(facture.get());
	         return ResponseEntity.status(HttpStatus.OK).build();
	     }
	     return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	 }
	 
	 @DeleteMapping("{id}")
	 public ResponseEntity<Void> destroy(@PathVariable(value = "id") Long id) {
	     Optional<Facture> facture = factureRepo.findById(id);
	     if (facture.isPresent()) {
	    	 factureRepo.deleteById(id);
	         return ResponseEntity.status(HttpStatus.OK).build();
	     }
	     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 }
}
