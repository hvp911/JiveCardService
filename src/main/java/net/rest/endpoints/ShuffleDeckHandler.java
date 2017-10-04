package net.rest.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.rest.exception.APIException;
import net.rest.helper.DeckHelper;
import net.rest.response.ResponseStatus;
import net.rest.response.ResponseWriter;

@Path("")
public class ShuffleDeckHandler {
	public ShuffleDeckHandler() {
		deckHelper = DeckHelper.getDeckHelper();
	}

	@POST
	@Path("/rest/shuffle")
	public Response shuffleDeck() throws APIException {
		// TODO: Should return shuffle success or failure.
		if (!deckHelper.validateDeck()) {
			return ResponseWriter.write("Deck is not populated correctly.", ResponseStatus.BAD_REQUEST);
		}
		deckHelper.shuffleDeck();
		return ResponseWriter.ok("Deck Shuffled Successfully.");
	}

	private DeckHelper deckHelper;

}
