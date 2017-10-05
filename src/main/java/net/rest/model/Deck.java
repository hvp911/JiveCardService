package net.rest.model;

import java.util.ArrayList;
import java.util.Random;

import net.rest.model.Card;

/**
 * Deck model. Contains operations that can be performed on Deck.
 */
public class Deck {

	private Deck() {
	}

	public static Deck getDeck() {
		if (instance == null) {
			instance = new Deck();
		}
		return instance;
	}

	public void initializeCardDeck() {
		this.cardDeck = new ArrayList<Card>();
	}

	public void addCardToDeck(Card card) {
		cardDeck.add(card);
	}

	public boolean isvalidCardDeck() {
		// Check if cardDeck is null.
		return (this.cardDeck != null);
	}

	public boolean isEmptyDeck() {
		// Check if cardDeck is empty.
		return this.cardDeck.isEmpty();
	}

	public Card getNextCard() {
		// Return next card from the deck.
		if (this.cardDeck.isEmpty()) {
			return null;
		}
		Card cardToDeal = null;
		synchronized (instance) {
			cardToDeal = this.cardDeck.get(0);
			this.cardDeck.remove(0);
		}
		return cardToDeal;
	}

	public void shuffleDeck() {
		// Shuffle deck.
		ArrayList<Card> shuffledCardDeck = new ArrayList<Card>();
		synchronized (instance) {
			int cardDeckSize = this.cardDeck.size();
			// Synchronization is not happening here. need to check
			for (int i = 0; i < cardDeckSize; i++) {
				int randomIndex = rand.nextInt(this.cardDeck.size());
				shuffledCardDeck.add(this.cardDeck.get(randomIndex));
				this.cardDeck.remove(randomIndex);
			}
			this.cardDeck = shuffledCardDeck;
		}
	}

	private Random rand = new Random();
	private ArrayList<Card> cardDeck;
	private static Deck instance;
}
