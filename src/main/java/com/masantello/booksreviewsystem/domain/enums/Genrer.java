package com.masantello.booksreviewsystem.domain.enums;

public enum Genrer {

	FANTASY(1, "Fantasy"),
	SCIENCE_FICTION(2, "Science Fiction"),
	DYSTOPIAN(3, "Dystopian"),
	ACTION(4, "Action"),
	BIOGRAPHY(5, "Biography"),
	MISTERY(6, "Mistery"),
	ROMANCE(7, "Romance"),
	ADVENTURE(8, "Adventure"),
	HISTORY(9, "History"),
	THRILLER(10, "Thriller"),
	FOOD_AND_DRINK(11, "Food and Drink"),
	SELF_HELP(12, "Self Help"),
	HORROR(13, "Horror"),
	TRUE_CRIME(14, "True Crime"),
	HUMOR(15, "Humor"),
	RELIGION_SPIRITUALITY(16, "Religion and Spirituality"),
	SOCIAL_SCIENCES(17, "Social Sciences"),
	PARENTING_FAMILIES(18, "Parenting and Families"),
	SCIENCE_TECHNOLOGY(19, "Science and Technology"),
	CHILDRENS(20, "Children's");
	
	private Integer code;
	private String description;
	
	private Genrer(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Genrer findByCode(Integer code) {
		for (Genrer genrer : Genrer.values()) {
			if (genrer.getCode() == code) {
				return genrer;
			}
		}
		return null;
	}
	
	public static Genrer findByDescription(String description) {
		for (Genrer genrer : Genrer.values()) {
			if (genrer.getDescription().equalsIgnoreCase(description)) {
				return genrer;
			}
		}
		return null;
	}
	
}
