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

import com.entities.Produit;
import com.entities.Stock;
import com.metier.GestionProduit;

@Path("/ProduitService")
public class ProduitService {

	GestionProduit gprod=new GestionProduit();
	   @GET 
	   @Path("/produits") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<Produit> getProduits(){ 
	      return gprod.ConsulterProduit();
	   }  
	   @GET 
	   @Path("/produits/{id_prod}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public Produit getProduit(@PathParam("id_prod") int id_prod){ 
	      return gprod.chercherProduit(id_prod); 
	   }  
	   @PUT 
	   @Path("/produits") 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void createProduit(@FormParam("id_prod")int id_prod, 
			   @FormParam("ref_produit")String ref_produit,
			   @FormParam("date_fab") Date date_fab, 
			   @FormParam("prix")int prix,
			   @FormParam("stock")Stock stock,
	      @Context HttpServletResponse servletResponse) throws IOException{ 
	      Produit prod = new Produit(id_prod,ref_produit,date_fab,prix,stock); 
	      gprod.ajoutProduit(prod);  
	   }  
	   @POST 
	   @Path("/produits")  
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void updateProduit(@FormParam("id_prod")int id_prod, 
			   @FormParam("ref_produit")String ref_produit,
			   @FormParam("date_fab") Date date_fab, 
			   @FormParam("prix")int prix,
			   @FormParam("stock")Stock stock, 
	           @Context HttpServletResponse servletResponse) throws IOException{ 
	      Produit prod = new Produit(id_prod,ref_produit,date_fab,prix,stock);
	      gprod.modifierProduit(prod);  
	   }  
	   @DELETE 
	   @Path("/produits/{id_prod}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public void deleteProduit(@PathParam("id_prod") int id_prod){ 
	       gprod.supprimerProduit(id_prod); 
	   }  
}
