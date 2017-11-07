package com.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "gamme") 
@Entity
@Table(name="gamme")
public class Gamme implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_gamme")
	private int id_gamme;
	@Column(name="designation_gamme",nullable=false)
	private String designation_gamme;
	@ManyToOne(
			cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="id_gam_prod")
	private Produit produit;
	public Gamme() {
	}
	public Gamme(int id_gamme, String designation_gamme, Produit produit) {
		super();
		this.id_gamme = id_gamme;
		this.designation_gamme = designation_gamme;
		this.produit = produit;
	}
	public int getId_gamme() {
		return id_gamme;
	}
	public void setId_gamme(int id_gamme) {
		this.id_gamme = id_gamme;
	}
	public String getDesignation_gamme() {
		return designation_gamme;
	}
	public void setDesignation_gamme(String designation_gamme) {
		this.designation_gamme = designation_gamme;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
}
