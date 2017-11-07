package consommateurs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.entities.Gamme;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GammeCunsommer {
	public List<Gamme> GatAllClient(){
	    List<Gamme> gammes=new ArrayList<Gamme>();
	       ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/GammeService/Gammes/list");
	    Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type", MediaType.APPLICATION_XML);
	    ClientResponse response = builder.get(ClientResponse.class);
	    GenericType<List<Gamme>> generic = new GenericType<List<Gamme>>(){};
	    gammes = response.getEntity(generic);
	    return gammes;
			
		}

	public Gamme getGamme(int id){
		ClientConfig clientConfig = new DefaultClientConfig();
	    Client client = Client.create(clientConfig);
	    WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/Gammes/get/id");
	      Builder builder = webResource.accept(MediaType.APPLICATION_XML)
	              .header("content-type", MediaType.APPLICATION_XML);
	      ClientResponse response = builder.get(ClientResponse.class);
	      Gamme g = (Gamme) response.getEntity(Gamme.class);
	      return g;
	}
	/*********************************************AJOUT***********************************/
	public void addGamme(Gamme g){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/Gammes/create");
		
		// Data send to web service.
		String input = "<Gamme>"+ 
		       "<id_stk>"+g.getId_gamme()+"</id_stk>"+
				"<designation_gamme>"+g.getDesignation_gamme() +"</designation_gamme>"+
		       "<produit>"+g.getProduit()+"</produit>"
		+ "</Gamme>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml")
		.post(ClientResponse.class, input);
		//String output = response.getEntity(String.class);
	}
	public void updateGamme(Gamme g){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/Gammes/update");
		
		// Data send to web service.
		String input = "<Gamme>"+ 
			       "<id_stk>"+g.getId_gamme()+"</id_stk>"+
					"<designation_gamme>"+g.getDesignation_gamme() +"</designation_gamme>"+
			       "<produit>"+g.getProduit()+"</produit>"
			+ "</Gamme>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").put(ClientResponse.class, input);
	}
	public void deleteGamme(int id){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/Gammes/delete/id");
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").delete(ClientResponse.class);
		}
}


