package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "stock") 
@Entity
@Table(name="stock")
public class Stock implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_stk")
	private int id_stk ;
	@Column(name="qte_stock",nullable=false)
	private int qte_stk;
	@Column(name="emplacement",nullable=false)
	private String emplacement ;
	@OneToMany(mappedBy="stock")
	private List<Produit> produits;
	@OneToMany(mappedBy="stock")
	private List<MatierePremiere> matieres_premieres;
	public Stock() {
		
	}
	public Stock(int id_stk, int qte_stk, String emplacement) {
		this.id_stk = id_stk;
		this.qte_stk = qte_stk;
		this.emplacement = emplacement;
		produits =new ArrayList<Produit>();
		matieres_premieres = new ArrayList<MatierePremiere>();
	}
	public int getId_stk() {
		return id_stk;
	}
	public void setId_stk(int id_stk) {
		this.id_stk = id_stk;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public List<MatierePremiere> getMatieres_premieres() {
		return matieres_premieres;
	}
	public void setMatieres_premieres(List<MatierePremiere> matieres_premieres) {
		this.matieres_premieres = matieres_premieres;
	}
	public int getQte_stk() {
		return qte_stk;
	}
	public void setQte_stk(int qte_stk) {
		this.qte_stk = qte_stk;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
}
