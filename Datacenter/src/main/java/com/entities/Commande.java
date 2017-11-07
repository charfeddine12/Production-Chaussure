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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "commande") 
@Entity
@Table(name="commande")
public class Commande implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cmd")
	private int id_cmd;
	@Column(name="date_cmd",nullable=false)
	private Date date_cmd;
	@Column(name="qte",nullable=false)
	private int qte;
	@ManyToMany(
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinTable(
			joinColumns=@JoinColumn(name="commande"),
			inverseJoinColumns=@JoinColumn(name="produit")
			)
	private List <Produit>produits;
	@ManyToOne(
			cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="id_cmd_cli")
	private Clientt client;
	public Commande() {
	}
	public Commande(int id_cmd, Date date_cmd, int qte, Clientt client) {
		super();
		this.id_cmd = id_cmd;
		this.date_cmd = date_cmd;
		this.qte = qte;
		this.client = client;
		produits=new ArrayList<Produit>();
	}
	public int getId_cmd() {
		return id_cmd;
	}
	public void setId_cmd(int id_cmd) {
		this.id_cmd = id_cmd;
	}
	public Date getDate_cmd() {
		return date_cmd;
	}
	public void setDate_cmd(Date date_cmd) {
		this.date_cmd = date_cmd;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public Clientt getClient() {
		return client;
	}
	public void setClient(Clientt client) {
		this.client = client;
	}
	
	
}
