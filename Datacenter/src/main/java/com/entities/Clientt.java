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
@XmlRootElement(name = "client") 
@Entity
@Table(name="client")
public class Clientt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_cli")
	private int id_cli;
    @Column(name="nom_cli",nullable=false)
	private String nom_cli;
    @Column(name="tel_cli",nullable=false)
	private int tel_cli;
    @Column(name="mail_cli",nullable=false)
	private String mail_cli;
    @OneToMany(mappedBy="client")
	private List<Commande> commandes;
	public Clientt() {
	}
	public Clientt(int id_cli, String nom_cli, int tel_cli, String mail_cli) {
		this.id_cli = id_cli;
		this.nom_cli = nom_cli;
		this.tel_cli = tel_cli;
		this.mail_cli = mail_cli;
		commandes = new ArrayList<Commande>();
	}
	public int getId_cli() {
		return id_cli;
	}
	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}
	public String getNom_cli() {
		return nom_cli;
	}
	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}
	public int getTel_cli() {
		return tel_cli;
	}
	public void setTel_cli(int tel_cli) {
		this.tel_cli = tel_cli;
	}
	public String getMail_cli() {
		return mail_cli;
	}
	public void setMail_cli(String mail_cli) {
		this.mail_cli = mail_cli;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
}
