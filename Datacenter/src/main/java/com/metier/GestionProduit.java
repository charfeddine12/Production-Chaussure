package com.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.BDManipulation.HibernateUtils;
import com.entities.Produit;

public class GestionProduit implements IGestionProduit{

	@Override
	public void ajoutProduit(Produit prod) {
		Session s = HibernateUtils.getSession();
		Produit p= new Produit();
		p.setDate_fab(prod.getDate_fab());
		p.setGammes(prod.getGammes());
		p.setPrix(prod.getPrix());
		p.setRef_produit(prod.getRef_produit());
		p.setStock(prod.getStock());
		p.setCommandes(prod.getCommandes());
		s.close();
	}

	public void modifierProduit(Produit prod) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from produit where id_prod= :id");
		q.setParameter("id", prod.getId_prod());
		Produit p = (Produit) q.uniqueResult();
		// Modifications des attributs de l'objet
		p.setDate_fab(prod.getDate_fab());
		p.setGammes(prod.getGammes());
		p.setPrix(prod.getPrix());
		p.setRef_produit(prod.getRef_produit());
		p.setStock(prod.getStock());
		p.setCommandes(prod.getCommandes());
		// Prise en compte de la modification
		Transaction tx = s.beginTransaction();
		s.update(p);
		tx.commit();
		s.close();
	}

	@Override
	public void supprimerProduit(int id) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from produit where id_prod= :id");
		q.setParameter("id", id);
		Produit p = (Produit) q.uniqueResult();
		// Enregistrement de la suppression
		Transaction tx = s.beginTransaction();
		s.delete(p);
		tx.commit();
		s.close();
	}

	@Override
	public List<Produit> ConsulterProduit() {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from produit");
		List<Produit> lp=  q.getResultList();
		s.close();
		return lp;
	}

	@Override
	public Produit chercherProduit(int id) {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from matierepremiere where id_mp= :id");
		q.setParameter("id", id);
		Produit p = (Produit) q.uniqueResult();
		s.close();
		return p;
	}

	
}
