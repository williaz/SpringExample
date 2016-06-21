package edu.bo.rs;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import edu.bo.beans.ProductBean;

@Path("/hi")
public class HelloService {
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg)
	{
		String out="Jersey shout: "+msg;
		
		return Response.status(200).entity(out).build();

	}
	
	@GET
	@Path("{year}/{month}/{day}")
	public Response getDate(@PathParam("year") int year,
			@PathParam("month") int month,
			@PathParam("day") int day){
		
		
		String date=year+"/"+month+"/"+day;
		
		return Response.status(200).entity("Date: "+date).build();
		
	}
	
	@POST
	@Path("/add")
	
	public Response addUsr(@FormParam("id") int id,
			@FormParam("price") double price,
			@FormParam("name") String name){
		
		return Response.status(200).entity("Added+<br> Id: "+id
				+"<br> Name: " + name+"<br> Price: "+price).build();
		
		
	}
	
	@GET
	@Path("/example")
	//@Produces({"application/xml","application/json"})
	@Produces("application/json")
	public ProductBean getProduct()
	{
		ProductBean pd=new ProductBean();
		
		pd.setId(42);
		pd.setPrice(100.01);
		pd.setName("WillBest");
		
		return pd;
		
		
	}
	
	@GET
	@Path("/headers")
	public Response getContxt(@Context HttpHeaders headers)
	{
		String userAgent="will:<br>";
		for (String header: headers.getRequestHeaders().keySet())
		{
			String userAgentValue=headers.getRequestHeader(header).get(0);
			userAgent=userAgent+"\t"+header+"\t"+userAgentValue+"<br>";
			

		}
		
		
		String rs="get Header "+userAgent;
		return Response.status(200).entity(rs).build();
	}
	
	

}
