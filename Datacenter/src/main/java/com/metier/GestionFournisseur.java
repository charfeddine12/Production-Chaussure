package com.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.BDManipulation.HibernateUtils;
import com.entities.Fournisseur;

public class GestionFournisseur implements IGestionFournisseur{

	@Override
	public void ajoutFournisseur(Fournisseur fournisseur) {
		Session s = HibernateUtils.getSession();
		Fournisseur  f= new Fournisseur();
		f.setMail_four(fournisseur.getMail_four());
		f.setNom_four(fournisseur.getNom_four());
		f.setTel_four(fournisseur.getTel_four());
		f.setMatierepremieres(fournisseur.getMatierepremieres());
		s.close();
	}
	@Override
	public void modifierFournisseur(Fournisseur fournisseur) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from fournisseur where id_four= :id");
		q.setParameter("id", fournisseur.getId_four());
		Fournisseur f = (Fournisseur) q.uniqueResult();
		// Modifications des attributs de l'objet
		f.setMail_four(fournisseur.getMail_four());
		f.setNom_four(fournisseur.getNom_four());
		f.setTel_four(fournisseur.getTel_four());
		f.setMatierepremieres(fournisseur.getMatierepremieres());
		// Prise en compte de la modification
		Transaction tx = s.beginTransaction();
		s.update(f);
		tx.commit();
		s.close();
	}

	@Override
	public void supprimerFournisseur(int id) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from fournisseur where id_four= :id");
		q.setParameter("id", id);
		Fournisseur f = (Fournisseur) q.uniqueResult();
		// Enregistrement de la suppression
		Transaction tx = s.beginTransaction();
		s.delete(f);
		tx.commit();
		s.close();
	}

	@Override
	public List<Fournisseur> ConsulterFournisseur() {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from fournisseur");
		List<Fournisseur> lf =  q.getResultList();
		s.close();
		return lf;
	}

	@Override
	public Fournisseur chercherFournisseur(int id) {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from facture where id_fournisseur= :id");
		q.setParameter("id", id);
		Fournisseur f = (Fournisseur) q.uniqueResult();
		s.close();
		return f;
	}

	
}
