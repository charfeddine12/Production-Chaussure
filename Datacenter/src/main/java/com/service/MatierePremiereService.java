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

import com.entities.MatierePremiere;
import com.entities.Stock;
import com.metier.GestionMatierePremiere;

@Path("/MatierePremiereService")
public class MatierePremiereService {

	GestionMatierePremiere gmp=new GestionMatierePremiere();
	   @GET 
	   @Path("/matierespremieres") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<MatierePremiere> getMatierePremieres(){ 
	      return gmp.ConsulterMatierePremiere();
	   }  
	   @GET 
	   @Path("/matierespremieres/{id_mat}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public MatierePremiere getMatierePremiere(@PathParam("id_mat") int id_mat){ 
	      return gmp.chercherMatierePremiere(id_mat); 
	   }  
	   @PUT 
	   @Path("/matierespremieres") 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void createMatierePremiere(@FormParam("id_mat")int id_mat, 
			   @FormParam("designation_mat")String desigantion_mat,
			   @FormParam("stock")Stock stock,
	      @Context HttpServletResponse servletResponse) throws IOException{ 
	      MatierePremiere mat = new MatierePremiere(id_mat,desigantion_mat,stock); 
	      gmp.ajoutMatierePremiere(mat);;  
	   }  
	   @POST 
	   @Path("/matierespremieres")  
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void updateMatierePremiere(@FormParam("id_mat")int id_mat, 
			   @FormParam("designation_mat")String desigantion_mat,
			   @FormParam("stock")Stock stock, 
	           @Context HttpServletResponse servletResponse) throws IOException{ 
	      MatierePremiere mat = new MatierePremiere(id_mat,desigantion_mat,stock);
	      gmp.modifierMatierePremiere(mat);  
	   }  
	   @DELETE 
	   @Path("/mateierespremieres/{id_mat}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public void deleteMatierePremiere(@PathParam("id_mat") int id_mat){ 
	       gmp.supprimerMatierePremiere(id_mat); 
	   }  
}
