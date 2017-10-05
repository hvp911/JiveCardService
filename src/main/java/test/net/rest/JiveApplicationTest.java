package test.net.rest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// NOTE: This is sample test cases for the application created in specific time frame.
// Actually for the Rest application i would prefer to have specific test suite.

public class JiveApplicationTest {

	@Before
	public void beforeTest() {
		createOrResetDeck();
	}

	@After
	public void afterTest() {
		createOrResetDeck();
	}

	@Test
	public void testShuffleDeckUpdatesCardPositions() {
		// Arranges
		// Initialize a deck and get first card
		createOrResetDeck();
		String firstCardOnCreatedDeck = dealACard();

		// Reset deck and shuffle it
		createOrResetDeck();
		shuffleDeck();
		String firstCardOnShuffledDeck = dealACard();

		// Asserts
		assertNotEquals(firstCardOnCreatedDeck, firstCardOnShuffledDeck);

	}

	@Test
	public void testDealACardMethodToDealAllCards() {
		// Arranges
		ArrayList<String> cardsDelt = new ArrayList<String>();
		for (int i = 0; i < maxKnownCards; i++) {
			String dealACardResponse = dealACard();
			if (dealACardResponse == null) {
				fail("Received empty card. Deck was in invalid state.");
			}
			if (cardsDelt.contains(dealACardResponse)) {
				fail("Received already delt card");
			}
			cardsDelt.add(dealACardResponse);
		}

		// Check next returned card is empty card response once we have fetched
		// all 52 cards.
		String cardDeltAfterKnownCards = dealACard();

		// Asserts
		assertFalse(cardsDelt.contains(cardDeltAfterKnownCards));
		assertEquals(cardsDelt.size(), maxKnownCards);
		assertEquals(cardDeltAfterKnownCards, emptyCardResponse);
	}

	@Test
	public void testDealACardMethodToDealAllCardsOnShuffledDeck() {
		// Arranges
		shuffleDeck();
		ArrayList<String> cardsDelt = new ArrayList<String>();
		for (int i = 0; i < maxKnownCards; i++) {
			String dealACardResponse = dealACard();
			if (dealACardResponse == null) {
				fail("Received empty card. Deck was in invalid state.");
			}
			if (cardsDelt.contains(dealACardResponse)) {
				fail("Received already delt card");
			}
			cardsDelt.add(dealACardResponse);
		}

		String cardDeltAfterKnownCards = dealACard();

		// Asserts
		assertFalse(cardsDelt.contains(cardDeltAfterKnownCards));
		assertEquals(cardsDelt.size(), maxKnownCards);
		assertEquals(cardDeltAfterKnownCards, emptyCardResponse);
	}

	private String dealACard() {
		try {
			HttpUtility httpUtility = new HttpUtility();
			return httpUtility.getResponse(host + dealACardEndpoint);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unexpected error. TODO: Need better way to do this.");
			return null;
		}
	}

	private String createOrResetDeck() {
		try {
			HttpUtility httpUtility = new HttpUtility();
			return httpUtility.postResponse(host + createDeckEndpoint);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unexpected error. TODO: Need better way to do this.");
			return null;
		}

	}

	private String shuffleDeck() {
		try {
			HttpUtility httpUtility = new HttpUtility();
			return httpUtility.postResponse(host + shuffleDeckEndpoint);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unexpected error. TODO: Need better way to do this.");
			return null;
		}

	}

	private static final String host = "http://localhost:8081/rest/";
	private static final String createDeckEndpoint = "createdeck";
	private static final String shuffleDeckEndpoint = "shuffle";
	private static final String dealACardEndpoint = "dealacard";
	private static final String emptyCardResponse = "{}";
	private static final int maxKnownCards = 52;

}