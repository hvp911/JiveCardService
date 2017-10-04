package net.rest.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.rest.exception.APIException;
import net.rest.response.ResponseWriter;

@Path("")
public class ShuffleDeckHandler {

	@POST
	@Path("/rest/shuffle")
	public Response shuffleDeck() throws APIException {
		// TODO: Should return shuffle success or failure.
		
		return ResponseWriter.ok("deck shuffled");
	}

}
