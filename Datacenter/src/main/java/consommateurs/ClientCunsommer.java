package consommateurs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.entities.Clientt;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ClientCunsommer {
	
	
	public List<Clientt> GatAllClient(){
    List<Clientt> clients=new ArrayList<Clientt>();
       ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
    WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/clients/list");
    Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type", MediaType.APPLICATION_XML);
    ClientResponse response = builder.get(ClientResponse.class);
    GenericType<List<Clientt>> generic = new GenericType<List<Clientt>>(){};
    clients = response.getEntity(generic);
    return clients;
		
	}
	public Clientt getClient(int id){
		ClientConfig clientConfig = new DefaultClientConfig();
	    Client client = Client.create(clientConfig);
	    WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/clients/get/id");
	      Builder builder = webResource.accept(MediaType.APPLICATION_XML)
	              .header("content-type", MediaType.APPLICATION_XML);
	      ClientResponse response = builder.get(ClientResponse.class);
	      Clientt cl = (Clientt) response.getEntity(Clientt.class);
	      return cl;
	}
	/*********************************************AJOUT***********************************/
	public void addClient(Clientt cl){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/clients/create");
		// Data send to web service.
		String input = "<client>"+ 
		       "<nom_cli>"+cl.getNom_cli()+"</nom_cli>"+
				"<tel_cli>"+cl.getTel_cli()+"</tel_cli>"+
		       "<mail_cli>"+cl.getMail_cli()+"</mail_cli>"
		+ "</client>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml")
		.post(ClientResponse.class, input);
		//String output = response.getEntity(String.class);
	}
	public void updateClient(Clientt cl){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/clients/update");
		// Data send to web service.
		String input = "<client>"+ 
		       "<nom_cli>"+cl.getNom_cli()+"</nom_cli>"+
				"<tel_cli>"+cl.getTel_cli()+"</tel_cli>"+
		       "<mail_cli>"+cl.getMail_cli()+"</mail_cli>"
		+ "</client>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").put(ClientResponse.class, input);
	}
	public void deleteClient(int id){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/clients/delete/id");
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").delete(ClientResponse.class);
		}
}
