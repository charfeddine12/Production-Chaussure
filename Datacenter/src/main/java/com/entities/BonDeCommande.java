package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "bon_de_commande") 
@Entity
@Table(name="bondecommande")
public class BonDeCommande implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_b")
	private int id_b;
	@Column(name="num_bc",nullable=false)
	private int num_bc;
	@OneToOne
	@JoinColumn(
	name="client",
	referencedColumnName="id_cli"
	)
	private Clientt client;
	@OneToOne
	@JoinColumn(
	name="commande",
	referencedColumnName="id_cmd"
	)
	private Commande commande;
	public BonDeCommande() {
	}
	public BonDeCommande(int id_b, int num_bc, Clientt client, Commande commande) {
		this.id_b = id_b;
		this.num_bc = num_bc;
		this.client = client;
		this.commande = commande;
	}
	public int getId_b() {
		return id_b;
	}
	public void setId_b(int id_b) {
		this.id_b = id_b;
	}
	public int getNum_bc() {
		return num_bc;
	}
	public void setNum_bc(int num_bc) {
		this.num_bc = num_bc;
	}
	public Clientt getClient() {
		return client;
	}
	public void setClient(Clientt client) {
		this.client = client;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	

}
