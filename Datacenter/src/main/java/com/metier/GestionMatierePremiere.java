package com.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.BDManipulation.HibernateUtils;
import com.entities.MatierePremiere;


public class GestionMatierePremiere implements IGestionMatierePremiere{

	public void ajoutMatierePremiere(MatierePremiere mat) {
		Session s = HibernateUtils.getSession();
		MatierePremiere mp= new MatierePremiere();
		mp.setDesigantion_mat(mat.getDesigantion_mat());
		mp.setFournisseurs(mat.getFournisseurs());
		mp.setStock(mat.getStock());
		s.close();
	}

	public void modifierMatierePremiere(MatierePremiere mat) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query q = s.createQuery("from matierepremiere where id_mat= :id");
		q.setParameter("id", mat.getId_mat());
		MatierePremiere mp = (MatierePremiere) q.uniqueResult();
		// Modifications des attributs de l'objet
		mp.setDesigantion_mat(mat.getDesigantion_mat());
		mp.setFournisseurs(mat.getFournisseurs());
		mp.setStock(mat.getStock());
		// Prise en compte de la modification
		Transaction tx = s.beginTransaction();
		s.update(mp);
		tx.commit();
		s.close();
	}

	@Override
	public void supprimerMatierePremiere(int id) {
		Session s = HibernateUtils.getSession();
		// Récupération de l'objet d'aprés son id
		Query<MatierePremiere> q = s.createQuery("from matierepremiere where id_mat= :id");
		q.setParameter("id", id);
		MatierePremiere mp = q.uniqueResult();
		// Enregistrement de la suppression
		Transaction tx = s.beginTransaction();
		s.delete(mp);
		tx.commit();
		s.close();
	}

	@Override
	public List<MatierePremiere> ConsulterMatierePremiere() {
		Session s = HibernateUtils.getSession();
		Query<MatierePremiere> q = s.createQuery("from matierepremiere");
		List<MatierePremiere> lmp=  q.getResultList();
		s.close();
		return lmp;
	}

	@Override
	public MatierePremiere chercherMatierePremiere(int id) {
		Session s = HibernateUtils.getSession();
		Query<MatierePremiere> q = s.createQuery("from matierepremiere where id_mp= :id");
		q.setParameter("id", id);
		MatierePremiere mp = q.uniqueResult();
		s.close();
		return mp;
	}

	
}
