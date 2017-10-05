package net.rest.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.rest.exception.APIException;
import net.rest.helper.DeckHelper;
import net.rest.response.ResponseWriter;

/**
 *  Create or Reset deck Endpoint.
 */
@Path("")
public class CreateOrResetDeckHandler {
	public CreateOrResetDeckHandler() {
		deckHelper = DeckHelper.getDeckHelper();
	}

	@POST
	@Path("/rest/createdeck")
	public Response createOrResetDeck() throws APIException {
		/*
		 * Reset the deck to have all 52 cards in it.
		 */
		deckHelper.createOrResetDeck();
		return ResponseWriter.created("Deck Created Successfully.");
	}

	private DeckHelper deckHelper;
}
