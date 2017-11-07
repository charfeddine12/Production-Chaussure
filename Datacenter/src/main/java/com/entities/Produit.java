package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "produit") 
@Entity
@Table(name="produit")
public class Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_prod")
	private int id_prod;
	@Column(name="ref_produit",nullable=false)
	private String ref_produit;
	@Column(name="date_fab",nullable=false)
	private Date date_fab;
	@Column(name="prix",nullable=false)
	private int prix ;
	@ManyToOne(
			cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="id_prod_stk")
	private Stock stock;
	@ManyToMany(
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinTable(
			joinColumns=@JoinColumn(name="produit"),
			inverseJoinColumns=@JoinColumn(name="commande")
			)
	private List <Commande>commandes;
	@OneToMany(mappedBy="produit")
	private List<Gamme> gammes;
	public Produit() {
	}
	public Produit(int id_prod, String ref_produit, Date date_fab, int prix, Stock stock) {
		this.id_prod = id_prod;
		this.ref_produit = ref_produit;
		this.date_fab = date_fab;
		this.prix = prix;
		this.stock = stock;
		commandes = new ArrayList<Commande>();
		gammes=new ArrayList<Gamme>();
	}
	public int getId_prod() {
		return id_prod;
	}
	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}
	public String getRef_produit() {
		return ref_produit;
	}
	public void setRef_produit(String ref_produit) {
		this.ref_produit = ref_produit;
	}
	public Date getDate_fab() {
		return date_fab;
	}
	public void setDate_fab(Date date_fab) {
		this.date_fab = date_fab;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public List<Gamme> getGammes() {
		return gammes;
	}
	public void setGammes(List<Gamme> gammes) {
		this.gammes = gammes;
	}
}
