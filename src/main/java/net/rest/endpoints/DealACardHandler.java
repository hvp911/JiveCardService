package net.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.rest.exception.APIException;
import net.rest.helper.DeckHelper;
import net.rest.response.ResponseStatus;
import net.rest.response.ResponseWriter;

@Path("")
public class DealACardHandler {
	public DealACardHandler() {
		deckHelper = DeckHelper.getDeckHelper();
	}

	@GET
	@Path("/rest/dealacard")
	public Response dealACard() throws APIException {
		if (!deckHelper.validateDeck()) {
			return ResponseWriter.write("Deck has not been created yet.", ResponseStatus.BAD_REQUEST);
		}
		return ResponseWriter.ok(deckHelper.dealACard());
	}

	private DeckHelper deckHelper;
}
