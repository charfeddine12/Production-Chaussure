package com.metier;

import java.util.List;

import com.entities.Facture;

public interface IGestionFacture {
	public void ajoutFacture(Facture fact);
	public void modifierFacture(Facture fact);
	public void supprimerFacture(int id);
	public List<Facture>ConsulterFacture();
	public Facture chercherFacture(int id);

}
