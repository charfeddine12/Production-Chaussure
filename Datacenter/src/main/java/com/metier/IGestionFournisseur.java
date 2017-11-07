package com.metier;

import java.util.List;

import com.entities.Fournisseur;

public interface IGestionFournisseur {
	public void ajoutFournisseur(Fournisseur fournisseur);
	public void modifierFournisseur(Fournisseur fournisseur);
	public void supprimerFournisseur(int id);
	public List<Fournisseur>ConsulterFournisseur();
	public Fournisseur chercherFournisseur(int id);
}
