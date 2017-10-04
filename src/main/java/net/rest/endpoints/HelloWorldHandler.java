package net.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.rest.exception.APIException;
import net.rest.response.ResponseWriter;

@Path("")
public class HelloWorldHandler {

	@GET
	@Path("/rest/helloworld")
	public Response getStart() throws APIException {
		return ResponseWriter.ok("helloworld");
	}

	@POST
	@Path("/rest/helloworldpost")
	public Response postStart() throws APIException {
		return ResponseWriter.ok("helloworld");
	}
}
