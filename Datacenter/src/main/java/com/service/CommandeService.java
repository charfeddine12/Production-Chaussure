package com.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.entities.Clientt;
import com.entities.Commande;
import com.metier.GestionCommande;

@Path("/commandeService")
public class CommandeService {
	GestionCommande gcommande=new GestionCommande();
	   @GET 
	   @Path("/commandes") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<Commande> getCommandes(){ 
	      return gcommande.ConsulterCommande();
	   }  
	   @GET 
	   @Path("/commandes/{id_cmd}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public Commande getCommande(@PathParam("id_cmd") int id_cmd){ 
	      return gcommande.chercherCommande(id_cmd); 
	   }  
	   @PUT 
	   @Path("/commandes") 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void createCommande(@FormParam("id_cmd")int id_cmd, 
			   @FormParam("date_cmd")Date date_cmd,
			   @FormParam("qte")int qte, 
			   @FormParam("client")Clientt client,
	      @Context HttpServletResponse servletResponse) throws IOException{ 
	      Commande cmd = new Commande(id_cmd,date_cmd,qte,client); 
	      gcommande.ajoutCommande(cmd);  
	   }  
	   @POST 
	   @Path("/commandes")  
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void updateCommande(@FormParam("id_cmd")int id_cmd, 
			   @FormParam("date_cmd")Date date_cmd,
			   @FormParam("qte")int qte, 
			   @FormParam("client")Clientt client, 
	           @Context HttpServletResponse servletResponse) throws IOException{ 
	      Commande cmd = new Commande(id_cmd,date_cmd,qte,client);
	      gcommande.modifierCommande(cmd); 
	   }  
	   @DELETE 
	   @Path("/commandes/{id_cmd}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public void deleteCommande(@PathParam("id_cmd") int id_cmd){ 
	       gcommande.supprimerCommande(id_cmd);; 
	   }  

}
