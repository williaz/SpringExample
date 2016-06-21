package edu.bo.rs;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.bo.beans.ProductBean;

public class RsClient {
	
	static private final String baseUrl="http://localhost:8081/RsExmp/rest/hi";

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			Client clt=ClientBuilder.newClient();
			WebTarget base=clt.target(baseUrl);
			WebTarget msg=base.path("{name}").resolveTemplate("name", "Bong");
			String res=msg.request().get(String.class);
			
			System.out.println(res);
			//XML
			WebTarget exp=base.path("example");
			ProductBean pb=exp.request(MediaType.APPLICATION_XML).get(ProductBean.class);// Client API auto-unmarshal XML
			System.out.println(pb);
			//JSON
			
//			Response resp=exp.request(MediaType.APPLICATION_JSON).get();// Client API auto-unmarshal JSON
//			ProductBean pb1=resp.readEntity(ProductBean.class);
//			System.out.println(pb1);
//			if(resp.getStatus()!=201){
//				throw new RuntimeException("HTTP Error: "+ resp.getStatus());
//			}

			
			
		} catch (WebApplicationException e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

	}

}
