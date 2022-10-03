package com.projet.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min=3, max = 50)
    private String nom;
    
    private int numreau;
    private String mf;
    private String rib;
    private String adresse;
    private String email;
    @ManyToMany(fetch = FetchType.LAZY,
  	      cascade = {
  	          CascadeType.PERSIST,
  	          CascadeType.MERGE
  	      })
  	  @JoinTable(name = "clients_factures",
  	        joinColumns = { @JoinColumn(name = "client_id") },
  	        inverseJoinColumns = { @JoinColumn(name = "facture_id") })
  	  private Set<Facture> factures=new HashSet<>();

    
    
	@Column(name = "created_at") @Temporal(TemporalType.TIMESTAMP) private Date createdAt = new Date();
    @Column(name = "updated_at") @Temporal(TemporalType.TIMESTAMP) private Date updatedAt = new Date();
	
	
	
	

	public Client(@Size(min = 3, max = 50) String nom, int numreau, String mf, String rib, String adresse, String email,Date createdAt, Date updatedAt) {
		super();
		this.nom = nom;
		this.numreau = numreau;
		this.mf = mf;
		this.rib = rib;
		this.adresse = adresse;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNumreau() {
		return numreau;
	}
	public void setNumreau(int numreau) {
		this.numreau = numreau;
	}
	public String getMf() {
		return mf;
	}
	public void setMf(String mf) {
		this.mf = mf;
	}
	public String getRib() {
		return rib;
	}
	public void setRib(String rib) {
		this.rib = rib;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Facture> getFactures() {
		return factures;
	}

	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}


    

}