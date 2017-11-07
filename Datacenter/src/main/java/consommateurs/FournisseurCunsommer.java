package consommateurs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.entities.Fournisseur;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class FournisseurCunsommer {
	
	
	public List<Fournisseur> GatAllFournisseurs(){
    List<Fournisseur> four=new ArrayList<Fournisseur>();
       ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
    WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/FournisseurService/Fournisseurs/list");
    Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type", MediaType.APPLICATION_XML);
    ClientResponse response = builder.get(ClientResponse.class);
    GenericType<List<Fournisseur>> generic = new GenericType<List<Fournisseur>>(){};
    four = response.getEntity(generic);
    return four;
	}
	public Fournisseur getFournisseur(int id){
		ClientConfig clientConfig = new DefaultClientConfig();
	    Client client = Client.create(clientConfig);
	    WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/FournisseurService/Fournisseurs/get/id");
	      Builder builder = webResource.accept(MediaType.APPLICATION_XML)
	              .header("content-type", MediaType.APPLICATION_XML);
	      ClientResponse response = builder.get(ClientResponse.class);
	      Fournisseur four = (Fournisseur) response.getEntity(Fournisseur.class);
	      return four;
	}
	
	public void addFournisseur(Fournisseur four){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/FournisseurService/Fournisseurs/create");
		// Data send to web service.
		String input = "<Fournisseur>"+ 
		       "<id>"+four.getId_four()+"</id>"+
				"<nom>"+four.getNom_four()+"</nom>"+
		       "<telephone>"+four.getTel_four()+"</telephone>"+
		       "<mail>"+four.getMail_four()+"</mail>"  
		+ "</Fournisseur>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml")
		.post(ClientResponse.class, input);
		//String output = response.getEntity(String.class);
	}
	public void updateFournisseur(Fournisseur four){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/FournisseurService/Fournisseurs/update");
		// Data send to web service.
		String input = "<Fournisseur>"+ 
			       "<id>"+four.getId_four()+"</id>"+
					"<nom>"+four.getNom_four()+"</nom>"+
			       "<telephone>"+four.getTel_four()+"</telephone>"+
			       "<mail>"+four.getMail_four()+"</mail>"  
			+ "</Fournisseur>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").put(ClientResponse.class, input);
	}
	public void deleteFournisseur(int id){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/Service/Fournisseurs/delete/id");
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").delete(ClientResponse.class);
		}
}