package com.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.BDManipulation.HibernateUtils;
import com.entities.Facture;

public class GestionFacture implements IGestionFacture{

	@Override
	public void ajoutFacture(Facture fact) {
		Session s = HibernateUtils.getSession();
		Facture  f= new Facture();
		f.setDate_fact(fact.getDate_fact());
		f.setFournisseur(fact.getFournisseur());
		f.setMatiere_premiere(fact.getMatiere_premiere());
		f.setMontant(fact.getMontant());
		f.setNum_fact(fact.getNum_fact());
		s.close();
	}

	@Override
	public void modifierFacture(Facture fact) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from facture where id_facture= :id");
		q.setParameter("id", fact.getId_fact());
		Facture f = (Facture) q.uniqueResult();
		// Modifications des attributs de l'objet
		f.setDate_fact(fact.getDate_fact());
		f.setFournisseur(fact.getFournisseur());
		f.setMatiere_premiere(fact.getMatiere_premiere());
		f.setMontant(fact.getMontant());
		f.setNum_fact(fact.getNum_fact());
		// Prise en compte de la modification
		Transaction tx = s.beginTransaction();
		s.update(f);
		tx.commit();
		s.close();		
	}

	@Override
	public void supprimerFacture(int id) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from facture where id_facture= :id");
		q.setParameter("id", id);
		Facture f = (Facture) q.uniqueResult();
		// Enregistrement de la suppression
		Transaction tx = s.beginTransaction();
		s.delete(f);
		tx.commit();
		s.close();			
	}
	@Override
	public List<Facture> ConsulterFacture() {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from facture");
		List<Facture> lf =  q.getResultList();
		s.close();
		return lf;
	}

	@Override
	public Facture chercherFacture(int id) {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from facture where id_facture= :id");
		q.setParameter("id", id);
		Facture f = (Facture) q.uniqueResult();
		s.close();
		return f;
	}

	
}
