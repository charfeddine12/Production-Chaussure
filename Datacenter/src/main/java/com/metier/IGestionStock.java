package com.metier;
import java.util.List;

import com.entities.*;
public interface IGestionStock {
	public void ajoutStock(Stock stk);
	public void modifierStock(Stock stk);
	public void supprimerStock(int id);
	public List<Stock>ConsulterStock();
	public Stock chercherStock(int id);

}
