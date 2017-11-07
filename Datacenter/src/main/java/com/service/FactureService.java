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
import com.entities.Facture;
import com.entities.Fournisseur;
import com.entities.MatierePremiere;
import com.metier.GestionFacture;

@Path("/FactureService")
public class FactureService {
	   GestionFacture gfacture=new GestionFacture();
	   @GET 
	   @Path("/factures") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<Facture> getFactures(){ 
	      return gfacture.ConsulterFacture();
	   }  
	   @GET 
	   @Path("/factures/{id_fact}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public Facture getFacture(@PathParam("id_fact") int id_fact){ 
	      return gfacture.chercherFacture(id_fact); 
	   }  
	   @PUT 
	   @Path("/factures") 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void createFacture(@FormParam("id_fact")int id_fact, 
			   @FormParam("num_fact")String num_fact,
			   @FormParam("date_fact")Date date_fact, 
			   @FormParam("montant")int montant, 
			   @FormParam("fournisseur")Fournisseur fournisseur,
			   @FormParam("matiere_premiere")MatierePremiere matiere_premiere,
	      @Context HttpServletResponse servletResponse) throws IOException{ 
	      Facture fact = new Facture(id_fact, num_fact,date_fact,montant,fournisseur,matiere_premiere); 
	      gfacture.ajoutFacture(fact);  
	   }  
	   @POST 
	   @Path("/factures")  
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void updateFacture(@FormParam("id_fact")int id_fact, 
			   @FormParam("num_fact")String num_fact,
			   @FormParam("date_fact")Date date_fact, 
			   @FormParam("montant")int montant, 
			   @FormParam("fournisseur")Fournisseur fournisseur,
			   @FormParam("matiere_premiere")MatierePremiere matiere_premiere, 
	           @Context HttpServletResponse servletResponse) throws IOException{ 
	      Facture fact = new Facture(id_fact, num_fact,date_fact,montant,fournisseur,matiere_premiere);
	      gfacture.modifierFacture(fact);  
	   }  
	   @DELETE 
	   @Path("/factures/{id_fact}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public void deleteFacture(@PathParam("facture") int id_fact){ 
	       gfacture.supprimerFacture(id_fact); 
	   }  
}
