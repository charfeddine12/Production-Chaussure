package com.metier;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.BDManipulation.HibernateUtils;
import com.entities.BonDeCommande;

public class GestionBonDeCommande implements IGestionBonDeCommande {

	public void ajoutBonDeCommande(BonDeCommande b) {
		Session s = HibernateUtils.getSession();
		BonDeCommande bc = new BonDeCommande();
		bc.setClient(b.getClient());
		bc.setCommande(b.getCommande());
		bc.setNum_bc(b.getNum_bc());
		s.close();
		
	}
	public void modifierBonDeCommande(BonDeCommande b) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from bondecommande where id_b= :id");
		q.setParameter("id", b.getId_b());
		BonDeCommande bc = (BonDeCommande) q.uniqueResult();
		// Modifications des attributs de l'objet
		bc.setClient(b.getClient());
		bc.setCommande(b.getCommande());
		bc.setNum_bc(b.getNum_bc());
		// Prise en compte de la modification
		Transaction tx = s.beginTransaction();
		s.update(bc);
		tx.commit();
		s.close();
	}
	public void supprimerBonDeCommande(int id) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from bondecommande where id_b= :id");
		q.setParameter("id", id);
		BonDeCommande bc = (BonDeCommande) q.uniqueResult();
		// Enregistrement de la suppression
		Transaction tx = s.beginTransaction();
		s.delete(bc);
		tx.commit();
		s.close();
	}

	@Override
	public List<BonDeCommande> ConsulterBonDeCommande() {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from bondecommande");
		List<BonDeCommande> bc =  q.getResultList();
		s.close();
		return bc;
	}

	@Override
	public BonDeCommande chercherBonDeCommande(int id) {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from bondecommande where id_b= :id");
		q.setParameter("id", id);
		BonDeCommande bc = (BonDeCommande) q.uniqueResult();
		s.close();
		return bc;
		
	}

}
