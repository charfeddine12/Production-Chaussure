package com.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.BDManipulation.HibernateUtils;
import com.entities.Gamme;

public class GestionGamme implements IGestionGamme{

	
	public void ajoutGamme(Gamme gamme) {
		Session s = HibernateUtils.getSession();
		Gamme g= new Gamme();
		g.setDesignation_gamme(gamme.getDesignation_gamme());
		g.setProduit(gamme.getProduit());
		s.close();		
	}

	
	public void modifierGamme(Gamme gamme) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from fournisseur where id_gamme= :id");
		q.setParameter("id", gamme.getId_gamme());
		Gamme g = (Gamme) q.uniqueResult();
		// Modifications des attributs de l'objet
		g.setDesignation_gamme(gamme.getDesignation_gamme());
		g.setProduit(gamme.getProduit());
		// Prise en compte de la modification
		Transaction tx = s.beginTransaction();
		s.update(g);
		tx.commit();
		s.close();
	}

	@Override
	public void supprimerGamme(int id) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from fournisseur where id_gamme= :id");
		q.setParameter("id", id);
		Gamme g = (Gamme) q.uniqueResult();
		// Enregistrement de la suppression
		Transaction tx = s.beginTransaction();
		s.delete(g);
		tx.commit();
		s.close();
	}

	@Override
	public List<Gamme> ConsulterGamme() {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from gamme");
		List<Gamme> lg =  q.getResultList();
		s.close();
		return lg;
	}

	@Override
	public Gamme chercherGamme(int id) {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from gamme where id_gamme= :id");
		q.setParameter("id", id);
		Gamme g = (Gamme) q.uniqueResult();
		s.close();
		return g;
	}

	

}
