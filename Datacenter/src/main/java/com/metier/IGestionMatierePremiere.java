package com.metier;

import java.util.List;

import com.entities.MatierePremiere;

public interface IGestionMatierePremiere {
	public void ajoutMatierePremiere(MatierePremiere mat);
	public void modifierMatierePremiere(MatierePremiere mat);
	public void supprimerMatierePremiere(int id);
	public List<MatierePremiere>ConsulterMatierePremiere();
	public MatierePremiere chercherMatierePremiere(int id);

}
