package com.projet.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Article {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private float prix_TTC;

 
    
    @ManyToOne(fetch = FetchType.LAZY)@JoinColumn(name = "id_Facture")@JsonIgnore private Facture facture;
    @Column(name = "Date_Declaration") @Temporal(TemporalType.TIMESTAMP) private Date dateDeclaration = new Date();
    @Column(name = "updated_at") @Temporal(TemporalType.TIMESTAMP) private Date updatedAt = new Date();
	
 


public Article(String nom, float prix_TTC, Facture facture, Date dateDeclaration, Date updatedAt) {
		super();
		this.nom = nom;
		this.prix_TTC = prix_TTC;
		this.facture = facture;
		this.dateDeclaration = dateDeclaration;
		this.updatedAt = updatedAt;
	}

public Article() {
	super();
	// TODO Auto-generated constructor stub
}

public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public float getPrix_TTC() {
	return prix_TTC;
}
public void setPrix_TTC(float prix_TTC) {
	this.prix_TTC = prix_TTC;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Facture getFacture() {
	return facture;
}

public void setFacture(Facture facture) {
	this.facture = facture;
}

public Date getDateDeclaration() {
	return dateDeclaration;
}

public void setDateDeclaration(Date dateDeclaration) {
	this.dateDeclaration = dateDeclaration;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

}
