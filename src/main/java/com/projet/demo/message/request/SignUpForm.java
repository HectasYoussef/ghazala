package com.projet.demo.message.request;

import javax.validation.constraints.*;

public class SignUpForm {

    @Size(min = 3, max = 50)
    private String nom;
    
 
    @Size(min = 3, max = 50)
    private String prenom;

    @Size(min = 3, max = 50)
    private String username;

    @Size(max = 60)
    @Email
    private String email;
    
    private String role;
    

    @Size(min = 6, max = 40)
    private String password;

	  
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    
    
    
    
    
}