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

import com.entities.Stock;
import com.metier.GestionStock;
@Path("/StockService")
public class StockService {
	GestionStock gstk=new GestionStock();
	   @GET 
	   @Path("/stocks") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<Stock> getStocks(){ 
	      return gstk.ConsulterStock();
	   }  
	   @GET 
	   @Path("/stocks/{id_stk}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public Stock getStock(@PathParam("id_stk") int id_stk){ 
	      return gstk.chercherStock(id_stk); 
	   }  
	   @PUT 
	   @Path("/stocks") 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void createStock(@FormParam("id_stk")int id_stk, 
			   @FormParam("qte_stk")int qte_stk, 
			   @FormParam("emplacement")String emplacement,
	      @Context HttpServletResponse servletResponse) throws IOException{ 
	      Stock stk  = new Stock(id_stk,qte_stk,emplacement); 
	      gstk.ajoutStock(stk);  
	   }  
	   @POST 
	   @Path("/stocks")  
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void updateStock(@FormParam("id_stk")int id_stk, 
			   @FormParam("qte_stk")int qte_stk, 
			   @FormParam("emplacement")String emplacement, 
	           @Context HttpServletResponse servletResponse) throws IOException{ 
	      Stock stk = new Stock(id_stk,qte_stk,emplacement);
	      gstk.modifierStock(stk);  
	   }  
	   @DELETE 
	   @Path("/stocks/{id_stk}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public void deleteStock(@PathParam("id_stk") int id_stk){ 
	       gstk.supprimerStock(id_stk); 
	   }  
}
