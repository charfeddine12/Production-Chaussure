package com.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.BDManipulation.HibernateUtils;
import com.entities.Stock;

public class GestionStock implements IGestionStock{

	
	public void ajoutStock(Stock st){
		Session s = HibernateUtils.getSession();
		Stock stk= new Stock();
		stk.setEmplacement(st.getEmplacement());
		stk.setMatieres_premieres(st.getMatieres_premieres());
		stk.setProduits(st.getProduits());
		stk.setQte_stk(st.getQte_stk());
		s.close();
	}

	@Override
	public void modifierStock(Stock st) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from stock where id_stk= :id");
		q.setParameter("id",st.getId_stk() );
		Stock stk = (Stock) q.uniqueResult();
		// Modifications des attributs de l'objet
		stk.setEmplacement(st.getEmplacement());
		stk.setMatieres_premieres(st.getMatieres_premieres());
		stk.setProduits(st.getProduits());
		stk.setQte_stk(st.getQte_stk());
		// Prise en compte de la modification
		Transaction tx = s.beginTransaction();
		s.update(stk);
		tx.commit();
		s.close();
	}

	@Override
	public void supprimerStock(int id) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from stock where id_stk= :id");
		q.setParameter("id", id);
		Stock stk = (Stock) q.uniqueResult();
		// Enregistrement de la suppression
		Transaction tx = s.beginTransaction();
		s.delete(stk);
		tx.commit();
		s.close();
	}

	@Override
	public List<Stock> ConsulterStock() {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from stock");
		List<Stock> lstk=  q.getResultList();
		s.close();
		return lstk;
	}

	@Override
	public Stock chercherStock(int id) {
		Session s = HibernateUtils.getSession();
		Query q = s.createQuery("from stock where id_stk= :id");
		q.setParameter("id", id);
		Stock p = (Stock) q.uniqueResult();
		s.close();
		return p;
	}

	
}
