package com.metier;

import java.util.List;

import com.entities.Commande;

public interface IGestionCommande {
	public void ajoutCommande(Commande c);
	public void modifierCommande(Commande c);
	public void supprimerCommande(int id);
	public List<Commande>ConsulterCommande();
	public Commande chercherCommande(int id);

}
