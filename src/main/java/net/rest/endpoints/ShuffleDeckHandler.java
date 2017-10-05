package net.rest.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.rest.exception.APIException;
import net.rest.helper.DeckHelper;
import net.rest.response.ResponseStatus;
import net.rest.response.ResponseWriter;

/**
 * Shuffle deck Endpoint.
 */
@Path("")
public class ShuffleDeckHandler {
	public ShuffleDeckHandler() {
		deckHelper = DeckHelper.getDeckHelper();
	}

	@POST
	@Path("/rest/shuffle")
	public Response shuffleDeck() throws APIException {
		/*
		 * Shuffle a deck. This endpoint will shuffle any size of deck unless it
		 * is not empty. (If n cards have been delt then also shuffle is
		 * allowed.)
		 */
		if (!deckHelper.validateDeck()) {
			return ResponseWriter.write("Deck is not populated correctly.", ResponseStatus.BAD_REQUEST);
		}
		if (deckHelper.isEmptyDeck()) {
			return ResponseWriter.write("Deck is Empty. Repopulate a deck to shuffle.", ResponseStatus.BAD_REQUEST);
		}
		deckHelper.shuffleDeck();
		return ResponseWriter.ok("Deck Shuffled Successfully.");
	}

	private DeckHelper deckHelper;

}
