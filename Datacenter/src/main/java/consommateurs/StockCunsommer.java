package consommateurs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.entities.Facture;
import com.entities.Stock;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class StockCunsommer {
	public List<Stock> GatAllClient(){
	    List<Stock> stocks=new ArrayList<Stock>();
	       ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/StockService/stocks/list");
	    Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type", MediaType.APPLICATION_XML);
	    ClientResponse response = builder.get(ClientResponse.class);
	    GenericType<List<Stock>> generic = new GenericType<List<Stock>>(){};
	    stocks = response.getEntity(generic);
	    return stocks;
			
		}

	public Stock getStock(int id){
		ClientConfig clientConfig = new DefaultClientConfig();
	    Client client = Client.create(clientConfig);
	    WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/stocks/get/id");
	      Builder builder = webResource.accept(MediaType.APPLICATION_XML)
	              .header("content-type", MediaType.APPLICATION_XML);
	      ClientResponse response = builder.get(ClientResponse.class);
	      Stock sl = (Stock) response.getEntity(Stock.class);
	      return sl;
	}
	/*********************************************AJOUT***********************************/
	public void addStock(Stock s1){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/FactureService/Factures/create");
		// Data send to web service.
		String input =  "<stock>"+ 
			       "<id_stk>"+s1.getId_stk()+"</id_stk>"+
					"<qte_stk>"+s1.getQte_stk()+"</qte_stk>"+
			       "<emplacement>"+s1.getEmplacement()+"</emplacement>"
			+ "</stock>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml")
		.post(ClientResponse.class, input);
		//String output = response.getEntity(String.class);
	}
	public void updateStock(Stock s1){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/FactureService/Factures/update");
		// Data send to web service.
		String input = "<stock>"+ 
			       "<id_stk>"+s1.getId_stk()+"</id_stk>"+
					"<qte_stk>"+s1.getQte_stk()+"</qte_stk>"+
			       "<emplacement>"+s1.getEmplacement()+"</emplacement>"
			+ "</stock>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").put(ClientResponse.class, input);
	}
	public void deleteClient(int id){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/simple-service/rest/ClientService/stocks/delete/id");
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").delete(ClientResponse.class);
		}
}


