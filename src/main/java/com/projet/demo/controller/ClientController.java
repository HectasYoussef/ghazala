package com.projet.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.ClientResourcesBuilderCustomizer;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.demo.model.Client;
import com.projet.demo.repository.ClientRepository;
import com.projet.demo.repository.FactureRepository;
import com.projet.demo.repository.UserRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Api/Client")
public class ClientController {
	
	    @Autowired
	    private ClientRepository clientRepo;
	    private FactureRepository factureRepo;
	  
		@GetMapping("/list")
	    public List<Client> getAllClients(){
			List<Client> clients= clientRepo.findAll();
			return clients;
	    }
		
		 @GetMapping(path = "/{id}")
		 public Optional<Client> show(@PathVariable(value = "id")Long id) {
			    Optional<Client> clients = clientRepo.findById(id);
			     return clients;
			    				     
		 }	 
		 @PostMapping("/ajout")
		 public Client createClient(@RequestBody Client client) {
				return clientRepo.save(client);
			}
		 
		 @PutMapping("/{id}")
		 public ResponseEntity<Client> update(@RequestBody Client  clientRequert, @PathVariable(value = "id")Long id) {
		     Optional<Client> client = clientRepo.findById(id);
		     if (client.isPresent()) {
		    	 client.get().setNom(clientRequert.getNom());
		    	 client.get().setNumreau(clientRequert.getNumreau());
		    	 client.get().setMf(clientRequert.getMf());
		    	 client.get().setRib(clientRequert.getRib());
		    	 client.get().setAdresse(clientRequert.getAdresse());
		    	 client.get().setEmail(clientRequert.getEmail());
		    	 clientRepo.save(client.get());
		         return ResponseEntity.status(HttpStatus.OK).build();
		     }
		     return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		 }
		 @DeleteMapping("{id}")
		 public ResponseEntity<Void> destroy(@PathVariable(value = "id") Long id) {
		     Optional<Client> sujet = clientRepo.findById(id);
		     if (sujet.isPresent()) {
		    	 clientRepo.deleteById(id);
		         return ResponseEntity.status(HttpStatus.OK).build();
		     }
		     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
}
