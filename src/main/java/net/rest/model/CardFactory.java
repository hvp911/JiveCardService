package net.rest.model;

import net.rest.enums.CardValuesEnum;
import net.rest.enums.SuitesEnum;

public class CardFactory {

	public static Card getCard(SuitesEnum suite, CardValuesEnum value) {
		return new SuitedCard(suite, value);
	}
}
