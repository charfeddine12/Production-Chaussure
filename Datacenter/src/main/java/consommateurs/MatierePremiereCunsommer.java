package consommateurs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.entities.MatierePremiere;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class MatierePremiereCunsommer {
	public List<MatierePremiere> GatAllClient(){
	    List<MatierePremiere> matierepremieres =new ArrayList<MatierePremiere>();
	       ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/MatierePremiereService/MatierePremieres/list");
	    Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type", MediaType.APPLICATION_XML);
	    ClientResponse response = builder.get(ClientResponse.class);
	    GenericType<List<MatierePremiere>> generic = new GenericType<List<MatierePremiere>>(){};
	    matierepremieres = response.getEntity(generic);
	    return matierepremieres;
			
		}

	public MatierePremiere getMatierePremiere(int id){
		ClientConfig clientConfig = new DefaultClientConfig();
	    Client client = Client.create(clientConfig);
	    WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/MatierePremieres/get/id");
	      Builder builder = webResource.accept(MediaType.APPLICATION_XML)
	              .header("content-type", MediaType.APPLICATION_XML);
	      ClientResponse response = builder.get(ClientResponse.class);
	      MatierePremiere mp = (MatierePremiere) response.getEntity(MatierePremiere.class);
	      return mp;
	}
	/*********************************************AJOUT***********************************/
	public void addMatierePremiere(MatierePremiere mp){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/MatierePremieres/create");
		
		// Data send to web service.
		String input = "<MatierePremiere>"+ 
		       "<id_stk>"+mp.getId_mat()+"</id_stk>"+
				"<designation_MatierePremiere>"+mp.getDesigantion_mat() +"</designation_MatierePremiere>"+
		       "<Fournisseurs>"+mp.getFournisseurs()+"</Fournisseurs>"+
		       "<stock>"+mp.getStock()+"</stock>"
		+ "</MatierePremiere>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml")
		.post(ClientResponse.class, input);
		//String output = response.getEntity(String.class);
	}
	public void updateMatierePremiere(MatierePremiere mp){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/MatierePremieres/update");
		
		// Data send to web service.
		String input = "<MatierePremiere>"+ 
			       "<id_stk>"+mp.getId_mat()+"</id_stk>"+
					"<designation_MatierePremiere>"+mp.getDesigantion_mat() +"</designation_MatierePremiere>"+
			       "<Fournisseurs>"+mp.getFournisseurs()+"</Fournisseurs>"+
			       "<stock>"+mp.getStock()+"</stock>"
			+ "</MatierePremiere>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").put(ClientResponse.class, input);
	}
	public void deleteMatierePremiere(int id){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/MatierePremieres/delete/id");
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").delete(ClientResponse.class);
		}
}


