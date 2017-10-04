package net.rest.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.rest.exception.APIException;
import net.rest.response.ResponseWriter;

@Path("")
public class CreateOrResetDeckHandler {

	@POST
	@Path("/rest/createdeck")
	public Response createOrResetDeck() throws APIException {
		// TODO: Add logic to create deck here : 201
		
		return ResponseWriter.ok("deck created");
	}

}
