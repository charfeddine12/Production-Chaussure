package consommateurs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.entities.Facture;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class FactureCunsommer {
	
	
	public List<Facture> GatAllFactures(){
    List<Facture> fac=new ArrayList<Facture>();
       ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
    WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/FactureService/Factures/list");
    Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type", MediaType.APPLICATION_XML);
    ClientResponse response = builder.get(ClientResponse.class);
    GenericType<List<Facture>> generic = new GenericType<List<Facture>>(){};
    fac = response.getEntity(generic);
    return fac;
	}
	public Facture getBonDeFacture(int id){
		ClientConfig clientConfig = new DefaultClientConfig();
	    Client client = Client.create(clientConfig);
	    WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/FactureService/Factures/get/id");
	      Builder builder = webResource.accept(MediaType.APPLICATION_XML)
	              .header("content-type", MediaType.APPLICATION_XML);
	      ClientResponse response = builder.get(ClientResponse.class);
	      Facture c = (Facture) response.getEntity(Facture.class);
	      return c;
	}
	
	public void addFacture(Facture fac){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/FactureService/Factures/create");
		// Data send to web service.
		String input = "<Fournisseur>"+ 
		       "<id>"+fac.getId_fact()+"</id>"+
				"<numero_facture>"+fac.getNum_fact()+"</numero_facture>"+
		       "<date_facture>"+fac.getDate_fact()+"</date_facture>"+
		       "<montant>"+fac.getMontant()+"</montant>"+
		       "<fournisseur>"+fac.getFournisseur()+"</fournisseur>"+
		       "<matier_premiere>"+fac.getMatiere_premiere()+"</matier_premiere>"+ 
		       "</Fournisseur>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml")
		.post(ClientResponse.class, input);
		//String output = response.getEntity(String.class);
	}
	public void updateFacture(Facture fac){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/FactureService/Factures/update");
		// Data send to web service.
		String input = "<Fournisseur>"+ 
			       "<id>"+fac.getId_fact()+"</id>"+
					"<numero_facture>"+fac.getNum_fact()+"</numero_facture>"+
			       "<date_facture>"+fac.getDate_fact()+"</date_facture>"+
			       "<montant>"+fac.getMontant()+"</montant>"+
			       "<fournisseur>"+fac.getFournisseur()+"</fournisseur>"+
			       "<matier_premiere>"+fac.getMatiere_premiere()+"</matier_premiere>"+ 
			       "</Fournisseur>";
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").put(ClientResponse.class, input);
	}
	public void deleteFacture(int id){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Datacenter/rest/Service/Factures/delete/id");
		ClientResponse response = webResource.type("application/xml")
		.accept("application/xml").delete(ClientResponse.class);
		}
}