package net.rest.helper;

import net.rest.enums.CardValuesEnum;
import net.rest.enums.SuitesEnum;
import net.rest.model.Card;
import net.rest.model.CardFactory;
import net.rest.model.Deck;

/**
 * DeckHelper to perform operations on Deck. Only object visible to the
 * endpoints.
 */
public class DeckHelper {
	private DeckHelper() {
	}

	public static DeckHelper getDeckHelper() {
		if (instance == null) {
			instance = new DeckHelper();
		}
		return instance;
	}

	public boolean validateDeck() {
		return Deck.getDeck().isvalidCardDeck();
	}

	public boolean isEmptyDeck() {
		return Deck.getDeck().isEmptyDeck();
	}

	private static void createCardsForSuite(SuitesEnum suite) {
		for (CardValuesEnum cardValue : CardValuesEnum.values()) {
			Deck.getDeck().addCardToDeck(CardFactory.getCard(suite, cardValue));
		}
	}

	public void createOrResetDeck() {
		Deck.getDeck().initializeCardDeck();
		for (SuitesEnum suite : SuitesEnum.values()) {
			createCardsForSuite(suite);
		}
	}

	public void shuffleDeck() {
		Deck.getDeck().shuffleDeck();
	}

	public Card dealACard() {
		return Deck.getDeck().getNextCard();
	}

	private static DeckHelper instance;
}
