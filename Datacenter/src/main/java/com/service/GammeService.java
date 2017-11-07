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

import com.entities.Gamme;
import com.entities.Produit;
import com.metier.GestionGamme;
@Path("/GammeService")
public class GammeService {
	GestionGamme ggamme=new GestionGamme();
	   @GET 
	   @Path("/gammes") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<Gamme> getGammes(){ 
	      return ggamme.ConsulterGamme();
	   }  
	   @GET 
	   @Path("/gammes/{id_gamme}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public Gamme getGamme(@PathParam("id_gamme") int id_gamme){ 
	      return ggamme.chercherGamme(id_gamme); 
	   }  
	   @PUT 
	   @Path("/gammes") 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void createGamme(@FormParam("id_gamme")int id_gamme, 
			   @FormParam("designation_gamme")String designation_gamme,
			   @FormParam("produit")Produit produit,
	      @Context HttpServletResponse servletResponse) throws IOException{ 
	      Gamme gamme = new Gamme(id_gamme,designation_gamme,produit); 
	      ggamme.ajoutGamme(gamme); 
	   }  
	   @POST 
	   @Path("/gammes")  
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void updateGamme(@FormParam("id_gamme")int id_gamme, 
			   @FormParam("designation_gamme")String designation_gamme,
			   @FormParam("produit")Produit produit, 
	           @Context HttpServletResponse servletResponse) throws IOException{ 
	      Gamme gamme = new Gamme(id_gamme,designation_gamme,produit);
	      ggamme.modifierGamme(gamme);
	   }  
	   @DELETE 
	   @Path("/gammes/{id_gamme}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public void deleteFacture(@PathParam("id_gamme") int id_gamme){ 
	       ggamme.supprimerGamme(id_gamme);
	   }  

}
