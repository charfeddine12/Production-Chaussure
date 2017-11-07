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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "fournisseur") 
@Entity
@Table(name="fournisseur")
public class Fournisseur implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_four")
	int id_four;
	@Column(name="nom_four",nullable=false)
	String nom_four;
	@Column(name="tel_four",nullable=false)
	int tel_four;
	@Column(name="mail_four",nullable=false)
	String mail_four;
	@ManyToMany(
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinTable(
			joinColumns=@JoinColumn(name="fournisseur"),
			inverseJoinColumns=@JoinColumn(name="matierepremiere")
			)
	private List <MatierePremiere>matierepremieres;
	public Fournisseur() {
	}
	public Fournisseur(int id_four, String nom_four, int tel_four, String mail_four) {
		super();
		this.id_four = id_four;
		this.nom_four = nom_four;
		this.tel_four = tel_four;
		this.mail_four = mail_four;
		matierepremieres=new ArrayList<MatierePremiere>();
	}
	public int getId_four() {
		return id_four;
	}
	public void setId_four(int id_four) {
		this.id_four = id_four;
	}
	public String getNom_four() {
		return nom_four;
	}
	public void setNom_four(String nom_four) {
		this.nom_four = nom_four;
	}
	public int getTel_four() {
		return tel_four;
	}
	public void setTel_four(int tel_four) {
		this.tel_four = tel_four;
	}
	public String getMail_four() {
		return mail_four;
	}
	public void setMail_four(String mail_four) {
		this.mail_four = mail_four;
	}
	public List<MatierePremiere> getMatierepremieres() {
		return matierepremieres;
	}
	public void setMatierepremieres(List<MatierePremiere> matierepremieres) {
		this.matierepremieres = matierepremieres;
	}
	
	
}
