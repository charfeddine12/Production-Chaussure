package com.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.BDManipulation.HibernateUtils;
import com.entities.Commande;

public class GestionCommande implements IGestionCommande{

	
	public void ajoutCommande(Commande cmd) {
		Session s = HibernateUtils.getSession();
		Commande c = new Commande();
		c.setDate_cmd(cmd.getDate_cmd());
		c.setQte(cmd.getQte());
		c.setClient(cmd.getClient());
		c.setProduits(cmd.getProduits());
		s.close();
		
	}


	public void modifierCommande(Commande cmd) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from commande where id_cmd= :id");
		q.setParameter("id", cmd.getId_cmd());
		Commande c = (Commande) q.uniqueResult();
		// Modifications des attributs de l'objet
		c.setDate_cmd(cmd.getDate_cmd());
		c.setQte(cmd.getQte());
		c.setClient(cmd.getClient());
		c.setProduits(cmd.getProduits());
		// Prise en compte de la modification
		Transaction tx = s.beginTransaction();
		s.update(c);
		tx.commit();
		s.close();			
	}

	
	public void supprimerCommande(int id) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from commande where id_cmd= :id");
		q.setParameter("id", id);
		Commande c = (Commande) q.uniqueResult();
		// Enregistrement de la suppression
		Transaction tx = s.beginTransaction();
		s.delete(c);
		tx.commit();
		s.close();		
	}

	
	public List<Commande> ConsulterCommande() {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from commande");
		List<Commande> lc =  q.getResultList();
		s.close();
		return lc;
	}
	public Commande chercherCommande(int id) {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from client where id_cmd= :id");
		q.setParameter("id", id);
		Commande c = (Commande) q.uniqueResult();
		s.close();
		return c;
	}

}
