package consommateurs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.entities.Commande;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class CommandeCunsommer {
	
	
	public List<Commande> GatAllCommandes(){
    List<Commande> cmds=new ArrayList<Commande>();
       ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
    WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/CommandeService/commandes/list");
    Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type", MediaType.APPLICATION_XML);
    ClientResponse response = builder.get(ClientResponse.class);
    GenericType<List<Commande>> generic = new GenericType<List<Commande>>(){};
    cmds = response.getEntity(generic);
    return cmds;
	}
	public Commande getBonDeCommande(int id){
		ClientConfig clientConfig = new DefaultClientConfig();
	    Client client = Client.create(clientConfig);
	    WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/CommandeService/commandes/get/id");
	      Builder builder = webResource.accept(MediaType.APPLICATION_XML)
	              .header("content-type", MediaType.APPLICATION_XML);
	      ClientResponse response = builder.get(ClientResponse.class);
	      Commande c = (Commande) response.getEntity(Commande.class);
	      return c;
	}
	
	public void addBonDeCommande(Commande c){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/CommandeService/commandes/create");
		// Data send to web service.
		String input = "<commande>"+ 
		       "<id>"+c.getId_cmd()+"</id>"+
				"<date>"+c.getDate_cmd()+"</date>"+
		       "<qte>"+c.getQte()+"</qte>"+
		       "<produit>"+c.getProduits()+"</produit>"+
		       "<client>"+c.getClient()+"</client>"  
		+ "</commande>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml")
		.post(ClientResponse.class, input);
		//String output = response.getEntity(String.class);
	}
	public void updateCommande(Commande c){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/CommandeService/commandes/update");
		// Data send to web service.
		String input = "<commande>"+ 
			       "<date_cmd>"+c.getId_cmd()+"</date_cmd>"+
					"<qte>"+c.getDate_cmd()+"</qte>"+
			       "<client>"+c.getQte()+"</client>"+
			       "<client>"+c.getProduits()+"</client>"+
			       "<client>"+c.getClient()+"</client>"  
			+ "</commande>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").put(ClientResponse.class, input);
	}
	public void deleteCommande(int id){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/Service/commandes/delete/id");
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").delete(ClientResponse.class);
		}
}