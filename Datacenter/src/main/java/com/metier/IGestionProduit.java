package com.metier;

import java.util.List;

import com.entities.Produit;

public interface IGestionProduit {
	public void ajoutProduit(Produit prod);
	public void modifierProduit(Produit prod);
	public void supprimerProduit(int id);
	public List<Produit>ConsulterProduit();
	public Produit chercherProduit(int id);
}
