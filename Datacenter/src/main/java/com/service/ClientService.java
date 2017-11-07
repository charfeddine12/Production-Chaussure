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

import com.entities.Clientt;
import com.metier.GestionClient;

@Path("/ClientService")
public class ClientService {
	GestionClient gclient=new GestionClient();
	   @GET 
	   @Path("/clients/list") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<Clientt> getClients(){ 
	      return gclient.ConsulterClient();
	   }  
	   @GET 
	   @Path("/clients/get/{id_cl}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public Clientt getCleint(@PathParam("id_cl") int id_cl){ 
	      return gclient.chercherClient(id_cl);
	   }  
	   @PUT 
	   @Path("/clients/create") 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void createClient(@FormParam("id_cli")int id_cli, 
			   @FormParam("nom_cli")String nom_cli, 
			   @FormParam("tel_cli")int tel_cli, 
			   @FormParam("mail_cli")String mail_cli,
	      @Context HttpServletResponse servletResponse) throws IOException{ 
	     Clientt cl = new Clientt(id_cli,nom_cli,tel_cli,mail_cli); 
	      gclient.ajoutClient(cl); 
	   }  
	   @POST 
	   @Path("/clients/update")  
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public void updateClient(@FormParam("id_cli")int id_cli, 
			   @FormParam("nom_cli")String nom_cli, 
			   @FormParam("tel_cli")int tel_cli, 
			   @FormParam("mail_cli")String mail_cli, 
	           @Context HttpServletResponse servletResponse) throws IOException{ 
	      Clientt cl = new Clientt(id_cli,nom_cli,tel_cli,mail_cli);
	      gclient.modifierClient(cl); 
	   }  
	   @DELETE 
	   @Path("/clients/delete/{id_cl}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public void deleteClient(@PathParam("id_client") int id_cl){ 
	       gclient.supprimerClient(id_cl); 
	   }  

}
