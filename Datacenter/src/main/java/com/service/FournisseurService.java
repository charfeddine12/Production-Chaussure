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

import com.entities.Fournisseur;
import com.metier.GestionFournisseur;

@Path("/FournisseurService")
public class FournisseurService {
	GestionFournisseur gfournisseur=new GestionFournisseur();
	   @GET 
	   @Path("/fournisseurs") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<Fournisseur> getFournisseurs(){ 
	      return gfournisseur.ConsulterFournisseur();
	   }  
	   @GET 
	   @Path("/fournisseurs/{id_four}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public Fournisseur getFournisseur(@PathParam("id_four") int id_four){ 
	      return gfournisseur.chercherFournisseur(id_four); 
	   }  
	   @PUT 
	   @Path("/fournisseurs") 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void createFournisseur(@FormParam("id_four")int id_four,
			   @FormParam("nom_four")String nom_four,
			   @FormParam("tel_four")int tel_four,
			   @FormParam("mail_four")String mail_four,
	      @Context HttpServletResponse servletResponse) throws IOException{ 
	      Fournisseur fournisseur = new Fournisseur(id_four,nom_four,tel_four,mail_four); 
	      gfournisseur.ajoutFournisseur(fournisseur);  
	   }  
	   @POST 
	   @Path("/fournisseurs")  
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void updateFournisseur(@FormParam("id_four")int id_four,
			   @FormParam("nom_four")String nom_four,
			   @FormParam("tel_four")int tel_four,
			   @FormParam("mail_four")String mail_four, 
	           @Context HttpServletResponse servletResponse) throws IOException{ 
	      Fournisseur fournisseur = new Fournisseur(id_four,nom_four,tel_four,mail_four);
	      gfournisseur.modifierFournisseur(fournisseur); 
	   }  
	   @DELETE 
	   @Path("/ournisseurs/{id_four}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public void deleteFournisseur(@PathParam("id_four") int id_four){ 
	       gfournisseur.supprimerFournisseur(id_four); 
	   }  
}
