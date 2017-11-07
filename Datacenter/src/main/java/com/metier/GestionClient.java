package com.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.BDManipulation.HibernateUtils;
import com.entities.Clientt;
import com.entities.Commande;

public class GestionClient implements IGestionClient{

	
	public void ajoutClient (Clientt cl) {
		Session s = HibernateUtils.getSession();
		Clientt c = new Clientt();
		c.setCommandes(cl.getCommandes());
		c.setMail_cli(cl.getMail_cli());
		c.setNom_cli(cl.getNom_cli());
		c.setTel_cli(cl.getTel_cli());
		s.close();
		
	}


	public void modifierClient(Clientt cl) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from client where id_cli= :id");
		q.setParameter("id", cl.getId_cli());
		Clientt c = (Clientt) q.uniqueResult();
		// Modifications des attributs de l'objet
		c.setCommandes(cl.getCommandes());
		c.setMail_cli(cl.getMail_cli());
		c.setNom_cli(cl.getNom_cli());
		c.setTel_cli(cl.getTel_cli());
		// Prise en compte de la modification
		Transaction tx = s.beginTransaction();
		s.update(c);
		tx.commit();
		s.close();		
	}


	public void supprimerClient(int id) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from bondecommande where id_cli= :id");
		q.setParameter("id", id);
		Clientt c = (Clientt) q.uniqueResult();
		// Enregistrement de la suppression
		Transaction tx = s.beginTransaction();
		s.delete(c);
		tx.commit();
		s.close();
	}


	public List<Clientt> ConsulterClient() {
		
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from client");
		List<Clientt> lc =  q.getResultList();
		s.close();
		return lc;
	}


	public Clientt chercherClient(int id) {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from client where id_cli= :id");
		q.setParameter("id", id);
		Clientt c = (Clientt) q.uniqueResult();
		s.close();
		return c;
	}


}
