package consommateurs;

	import java.util.ArrayList;
	import java.util.List;

	import javax.ws.rs.core.MediaType;

	import com.entities.BonDeCommande;
	import com.sun.jersey.api.client.Client;
	import com.sun.jersey.api.client.ClientResponse;
	import com.sun.jersey.api.client.GenericType;
	import com.sun.jersey.api.client.WebResource;
	import com.sun.jersey.api.client.WebResource.Builder;
	import com.sun.jersey.api.client.config.ClientConfig;
	import com.sun.jersey.api.client.config.DefaultClientConfig;

	public class BonDeCommandeCunsommer {
		
		
		public List<BonDeCommande> GatAllBC(){
	    List<BonDeCommande> bcs=new ArrayList<BonDeCommande>();
	       ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/BonDeCommandeService/bondecommandes/list");
	    Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type", MediaType.APPLICATION_XML);
	    ClientResponse response = builder.get(ClientResponse.class);
	    GenericType<List<BonDeCommande>> generic = new GenericType<List<BonDeCommande>>(){};
	    bcs = response.getEntity(generic);
	    return bcs;
		}
		public BonDeCommande getBonDeCommande(int id){
			ClientConfig clientConfig = new DefaultClientConfig();
		    Client client = Client.create(clientConfig);
		    WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/BonDeCommandeService/bondecommandes/get/id");
		      Builder builder = webResource.accept(MediaType.APPLICATION_XML)
		              .header("content-type", MediaType.APPLICATION_XML);
		      ClientResponse response = builder.get(ClientResponse.class);
		      BonDeCommande bc = (BonDeCommande) response.getEntity(BonDeCommande.class);
		      return bc;
		}
		
		public void addBonDeCommande(BonDeCommande bc){
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/BonDeCommandeService/bondecommandes/create");
			// Data send to web service.
			String input = "<bondecommande>"+ 
			       "<num_bc>"+bc.getNum_bc()+"</num_bc>"+
					"<client>"+bc.getClient()+"</client>"+
			       "<commande>"+bc.getCommande()+"</commande>"
			+ "</bondecommande>";
			ClientResponse response = webResource.type("application/xml")
			.accept("application/xml")
			.post(ClientResponse.class, input);
			//String output = response.getEntity(String.class);
		}
		public void updateBC(BonDeCommande bc){
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/BonDeCommandeService/bondecommandes/update");
			// Data send to web service.
			String input = "<bondecommande>"+ 
			       "<num_bc>"+bc.getNum_bc()+"</num_bc>"+
					"<client>"+bc.getClient()+"</client>"+
			       "<commande>"+bc.getCommande()+"</commande>"
			+ "</bondecommande>";
			ClientResponse response = webResource.type("application/xml")
			.accept("application/xml").put(ClientResponse.class, input);
		}
		public void deleteBC(int id){
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/Service/bondecommandes/delete/id");
			ClientResponse response = webResource.type("application/xml")
			.accept("application/xml").delete(ClientResponse.class);
			}
	}


