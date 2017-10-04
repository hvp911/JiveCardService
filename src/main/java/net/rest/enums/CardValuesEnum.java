package net.rest.enums;

public enum CardValuesEnum {
	ACE("ACE"), 
	TWO("2"), 
	THREE("3"), 
	FOUR("4"), 
	FIVE("5"), 
	SIX("6"), 
	SEVEN("7"), 
	EIGHT("8"), 
	NINE("9"), 
	TEN("10"),
	JACK("JACK"), 
	QUEEN("QUEEN"), 
	KING("KING");

	CardValuesEnum(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;
}
