package com.metier;

import java.util.List;

import com.entities.BonDeCommande;

public interface IGestionBonDeCommande {

	public void ajoutBonDeCommande(BonDeCommande b);
	public void modifierBonDeCommande(BonDeCommande b);
	public void supprimerBonDeCommande(int id);
	public List<BonDeCommande>ConsulterBonDeCommande();
	public BonDeCommande chercherBonDeCommande(int id);
}
