package net.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.rest.exception.APIException;
import net.rest.response.ResponseWriter;

@Path("")
public class DealACardHandler {

	@GET
	@Path("/rest/dealacard")
	public Response dealACard() throws APIException {
		// TODO: Add logic to Deal a Card - Delt card will be returned as a response.
		// Structure should be:  200
		//		{ 
		//			response: { 
		//				card: {
		//					value: Ace
		//					suite: clubs
		//				}
		//			}
		//		}
		
		return ResponseWriter.ok("Card delt or not");
	}

}
