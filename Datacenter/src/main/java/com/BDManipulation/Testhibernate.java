package com.BDManipulation;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.BonDeCommande;
import com.entities.Clientt;
import com.entities.Commande;
import com.entities.Facture;
import com.entities.Fournisseur;
import com.entities.Gamme;
import com.entities.MatierePremiere;
import com.entities.Produit;
import com.entities.Stock;


public class Testhibernate {

	public static void main(String[] args) {
		// Récupération d'une session Hibernate
		
		Session s = HibernateUtils.getSession();
		// Début de la transactio
		Transaction t = s.beginTransaction();
		// Création d'un objet Event
		Clientt c = new Clientt(1,"charfi",22,"ffffff");
		Date d= new Date();
		Commande cmd =new Commande (1,d,40,c);
		BonDeCommande bdc =new BonDeCommande (1,2,c,cmd);
		Fournisseur four = new Fournisseur(1,"ggg",2,"hhh");
		Stock stk = new Stock(1,2,"str");
		Produit p=new Produit(1,"str",d,2,stk);
		MatierePremiere mp = new MatierePremiere(1,"et",stk);
		Facture fac =new Facture (1,"ff",d,2,four,mp);
		Gamme g=new Gamme(1,"sss",p);
		
		
		// Enregistrement de l'event
		s.save(c);
		s.save(p);
		s.save(cmd);
		s.save(bdc);
		s.save(four);
		s.save(stk);
		s.save(fac);
		s.save(mp);
		s.save(g);
		
		// Fin de la transaction
		t.commit();
		// Fermeture de la session Hibernate
		s.close();
	}
}