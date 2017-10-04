package net.rest.model;

import net.rest.enums.CardValuesEnum;
import net.rest.enums.SuitesEnum;

public class SuitedCard implements Card {

	public SuitedCard(SuitesEnum suite, CardValuesEnum value) {
		this.setSuite(suite);
		this.setValue(value);
	}

	@Override
	public Card getCard(SuitesEnum suite, CardValuesEnum value) {
		return new SuitedCard(suite, value);
	}

	public SuitesEnum getSuite() {
		return suite;
	}

	public void setSuite(SuitesEnum suite) {
		this.suite = suite;
	}

	public String getValue() {
		return value.getValue();
	}

	public void setValue(CardValuesEnum value) {
		this.value = value;
	}

	private SuitesEnum suite;
	private CardValuesEnum value;
}
