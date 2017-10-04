package net.rest.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.rest.exception.APIException;
import net.rest.helper.DeckHelper;
import net.rest.response.ResponseStatus;
import net.rest.response.ResponseWriter;

@Path("")
public class CreateOrResetDeckHandler {
	public CreateOrResetDeckHandler() {
		deckHelper = DeckHelper.getDeckHelper();
	}

	@POST
	@Path("/rest/createdeck")
	public Response createOrResetDeck() throws APIException {
		deckHelper.createOrResetDeck();
		return ResponseWriter.write("Deck Created Successfully.", ResponseStatus.CREATED);
	}

	private DeckHelper deckHelper;
}
