package net.rest.model;

import net.rest.enums.CardValuesEnum;
import net.rest.enums.SuitesEnum;

public interface Card {
	public Card getCard(SuitesEnum suite, CardValuesEnum value);
}
