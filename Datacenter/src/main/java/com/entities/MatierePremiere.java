package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "matiere_premiere") 
@Entity
@Table(name="matierepremiere")
public class MatierePremiere implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_mat")
	private int id_mat;
	@Column(name="designation_mat",nullable=false)
	String desigantion_mat;
	@ManyToMany(
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinTable(
			joinColumns=@JoinColumn(name="matierepremiere"),
			inverseJoinColumns=@JoinColumn(name="fournisseur")
			)
	private List <Fournisseur>fournisseurs;
	@ManyToOne(
			cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="id_stk_mat")
	private  Stock stock;
	public MatierePremiere() {
	}
	public MatierePremiere(int id_mat, String desigantion_mat,Stock stock) {
		super();
		this.id_mat = id_mat;
		this.desigantion_mat = desigantion_mat;
		fournisseurs=new ArrayList<Fournisseur>();
		this.stock = stock;
	}
	public int getId_mat() {
		return id_mat;
	}
	public void setId_mat(int id_mat) {
		this.id_mat = id_mat;
	}
	public String getDesigantion_mat() {
		return desigantion_mat;
	}
	public void setDesigantion_mat(String desigantion_mat) {
		this.desigantion_mat = desigantion_mat;
	}
	public List<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
}
