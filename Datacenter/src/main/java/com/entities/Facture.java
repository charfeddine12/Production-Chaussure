package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "facture") 
@Entity
@Table(name="facture")
public class Facture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_fact")
	int id_fact;
	@Column(name="num_fact",nullable=false)
	String num_fact;
	@Column(name="date_fact",nullable=false)
	Date date_fact;
	@Column(name="montant",nullable=false)
	int montant;
	@OneToOne
	@JoinColumn(
	name="fournisseur",
	referencedColumnName="id_four"
	)
	private Fournisseur fournisseur;
	@OneToOne
	@JoinColumn(
	name="matierepremiere",
	referencedColumnName="id_mat"
	)
	private MatierePremiere matiere_premiere;
	public Facture() {
	}
	public Facture(int id_fact, String num_fact, Date date_fact, int montant, Fournisseur fournisseur,
			MatierePremiere matiere_premiere) {
		super();
		this.id_fact = id_fact;
		this.num_fact = num_fact;
		this.date_fact = date_fact;
		this.montant = montant;
		this.fournisseur = fournisseur;
		this.matiere_premiere = matiere_premiere;
	}
	public int getId_fact() {
		return id_fact;
	}
	public void setId_fact(int id_fact) {
		this.id_fact = id_fact;
	}
	public String getNum_fact() {
		return num_fact;
	}
	public void setNum_fact(String num_fact) {
		this.num_fact = num_fact;
	}
	public Date getDate_fact() {
		return date_fact;
	}
	public void setDate_fact(Date date_fact) {
		this.date_fact = date_fact;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public MatierePremiere getMatiere_premiere() {
		return matiere_premiere;
	}
	public void setMatiere_premiere(MatierePremiere matiere_premiere) {
		this.matiere_premiere = matiere_premiere;
	}
	
	
	
}
