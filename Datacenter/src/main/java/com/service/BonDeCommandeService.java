package com.service;

import java.io.IOException;
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

import com.entities.BonDeCommande;
import com.entities.Clientt;
import com.entities.Commande;
import com.metier.GestionBonDeCommande;

@Path("/BonDeCommandeService")
public class BonDeCommandeService {

	GestionBonDeCommande gbc=new GestionBonDeCommande();
	   @GET 
	   @Path("/bondecommandes") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<BonDeCommande> getBonDeCommandes(){ 
	      return gbc.ConsulterBonDeCommande();
	   }  
	   @GET 
	   @Path("/bondecommandes/{id_bc}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public BonDeCommande getBonDeCommande(@PathParam("id_bc") int id_bc){ 
	      return gbc.chercherBonDeCommande(id_bc);
	   }  
	   @PUT 
	   @Path("/bondecommandes") 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void createBonDeCommande(@FormParam("id_b")int id_b,
			   @FormParam("num_bc")int num_bc,
			   @FormParam("client")Clientt client,
			   @FormParam("commande")Commande commande,
	      @Context HttpServletResponse servletResponse) throws IOException{ 
	      BonDeCommande b = new BonDeCommande(id_b,num_bc,client,commande); 
	      gbc.ajoutBonDeCommande(b);  
	   }  
	   @POST 
	   @Path("/bondecommandes")  
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void updateBonDeCommande(@FormParam("id_b")int id_b,
			   @FormParam("num_bc")int num_bc,
			   @FormParam("client")Clientt client,
			   @FormParam("commande")Commande commande, 
	           @Context HttpServletResponse servletResponse) throws IOException{ 
	      BonDeCommande b = new BonDeCommande(id_b,num_bc,client,commande);
	      gbc.modifierBonDeCommande(b);  
	   }  
	   @DELETE 
	   @Path("/bondecommandes/{id_bc}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public void deleteFacture(@PathParam("id_bc") int id_bc){ 
	       gbc.supprimerBonDeCommande(id_bc);
	   }  
}
