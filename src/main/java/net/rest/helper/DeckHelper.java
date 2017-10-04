package net.rest.helper;

import java.util.ArrayList;

import net.rest.enums.CardValuesEnum;
import net.rest.enums.SuitesEnum;
import net.rest.model.Card;
import net.rest.model.CardFactory;
import net.rest.model.Deck;

// TODO: Creating singleton for now. Should be injected using google guice.
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

	private static void createCardsForSuite(SuitesEnum suite) {
		for (CardValuesEnum cardValue : CardValuesEnum.values()) {
			Deck.getDeck().cardDeck.add(CardFactory.getCard(suite, cardValue));
		}
	}

	public void createOrResetDeck() {
		Deck.getDeck().cardDeck = new ArrayList<Card>();
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

	public ArrayList<Card> deltCard = new ArrayList<Card>();
	public static DeckHelper instance;
}
