package consommateurs;

	import java.util.ArrayList;
	import java.util.List;

	import javax.ws.rs.core.MediaType;

	import com.entities.Produit;

	import com.sun.jersey.api.client.Client;
	import com.sun.jersey.api.client.ClientResponse;
	import com.sun.jersey.api.client.GenericType;
	import com.sun.jersey.api.client.WebResource;
	import com.sun.jersey.api.client.WebResource.Builder;
	import com.sun.jersey.api.client.config.ClientConfig;
	import com.sun.jersey.api.client.config.DefaultClientConfig;

	public class ProduitCunsommer {
		public List<Produit> GatAllClient(){
		    List<Produit> Produits =new ArrayList<Produit>();
		       ClientConfig config = new DefaultClientConfig();
			Client client = Client.create(config);
		    WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ProduitService/Produits/list");
		    Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type", MediaType.APPLICATION_XML);
		    ClientResponse response = builder.get(ClientResponse.class);
		    GenericType<List<Produit>> generic = new GenericType<List<Produit>>(){};
		    Produits = response.getEntity(generic);
		    return Produits;
				
			}

		public Produit getProduit(int id){
			ClientConfig clientConfig = new DefaultClientConfig();
		    Client client = Client.create(clientConfig);
		    WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/Produits/get/id");
		      Builder builder = webResource.accept(MediaType.APPLICATION_XML)
		              .header("content-type", MediaType.APPLICATION_XML);
		      ClientResponse response = builder.get(ClientResponse.class);
		      Produit pl = (Produit) response.getEntity(Produit.class);
		      return pl;
		}
		/*********************************************AJOUT***********************************/
		public void addProduit(Produit pl){
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/Produits/create");
			// Data send to web service.
			Produit p1 = null;
			String input = "<Produit>"+ 
			       "<id_prod>"+p1.getId_prod()+"</id_prod>"+
					"<ref_produit>"+p1.getRef_produit()+"</ref_produit>"+
			       "<date_fab>"+p1.getDate_fab()+"</date_fab>"
			+ "</Produit>";
			ClientResponse response = webResource.type("application/xml")
			.accept("application/xml")
			.post(ClientResponse.class, input);
			//String output = response.getEntity(String.class);
		}
		public void updateClient(Produit pl){
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/Produits/update");
			// Data send to web service.
			Produit p1 = null;
			String input = "<Produit>"+ 
				       "<id_prod>"+p1.getId_prod()+"</id_prod>"+
						"<ref_produit>"+p1.getRef_produit()+"</ref_produit>"+
				       "<date_fab>"+p1.getDate_fab()+"</date_fab>"
				+ "</Produit>";
			ClientResponse response = webResource.type("application/xml")
			.accept("application/xml").put(ClientResponse.class, input);
		}
		public void deleteClient(int id){
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/Produits/delete/id");
			ClientResponse response = webResource.type("application/xml")
			.accept("application/xml").delete(ClientResponse.class);
			}
	

	}


