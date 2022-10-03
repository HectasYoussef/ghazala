package com.projet.demo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Facture {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private int numreauFacture;
	private String mf;
	
     private String client;
	   @Column(name = "created_at") @Temporal(TemporalType.TIMESTAMP) private Date createdAt = new Date();
       @Column(name = "updated_at") @Temporal(TemporalType.TIMESTAMP) private Date updatedAt = new Date();
    
 
	
	

	public Facture(int numreauFacture, String mf, String client, Date createdAt, Date updatedAt) {
		super();
		this.numreauFacture = numreauFacture;
		this.mf = mf;
		this.client = client;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setIdF(long idF) {
		this.id = idF;
	}
	public int getNumreauFacture() {
		return numreauFacture;
	}
	public void setNumreauFacture(int numreauFacture) {
		this.numreauFacture = numreauFacture;
	}
	public String getMf() {
		return mf;
	}
	public void setMf(String mf) {
		this.mf = mf;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
}
