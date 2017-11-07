package com.metier;

import java.util.List;

import com.entities.Clientt;

public interface IGestionClient {
	public void ajoutClient(Clientt cl);
	public void modifierClient(Clientt cl);
	public void supprimerClient(int id);
	public List<Clientt>ConsulterClient();
	public Clientt chercherClient(int id);

}
