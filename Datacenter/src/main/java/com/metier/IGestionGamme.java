package com.metier;

import java.util.List;

import com.entities.Gamme;
public interface IGestionGamme {
	public void ajoutGamme(Gamme gamme);
	public void modifierGamme(Gamme gamme);
	public void supprimerGamme(int id);
	public List<Gamme>ConsulterGamme();
	public Gamme chercherGamme(int id);
}
