package com.masantello.booksreviewsystem.models.enums;

public enum LiteraryGenre {

	ACTION(1, "Action"),
	ADVENTURE(2, "Adventure"),
	BIOGRAPHY(3, "Biography"),
	CHILDRENS(4, "Children's"),
	FANTASY(5, "Fantasy"),
	DYSTOPIAN(6, "Dystopian"),
	FOOD_AND_DRINK(7, "Food and Drink"),
	HISTORY(8, "History"),
	HORROR(9, "Horror"),
	HUMOR(10, "Humor"),
	MYSTERY(11, "Mystery"),
	PARENTING_FAMILIES(12, "Parenting and Families"),
	RELIGION_SPIRITUALITY(13, "Religion and Spirituality"),
	ROMANCE(14, "Romance"),
	SCIENCE_FICTION(15, "Science Fiction"),
	SCIENCE_TECHNOLOGY(16, "Science and Technology"),
	SELF_HELP(17, "Self Help"),
	SOCIAL_SCIENCES(18, "Social Sciences"),
	THRILLER(19, "Thriller"),
	TRUE_CRIME(20, "True Crime");
	
	private Integer code;
	private String description;
	
	private LiteraryGenre(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static LiteraryGenre findByCode(Integer code) {
		for (LiteraryGenre genrer : LiteraryGenre.values()) {
			if (genrer.getCode().equals(code)) {
				return genrer;
			}
		}
		return null;
	}
	
	public static LiteraryGenre findByDescription(String description) {
		for (LiteraryGenre genrer : LiteraryGenre.values()) {
			if (genrer.getDescription().equalsIgnoreCase(description)) {
				return genrer;
			}
		}
		return null;
	}
	
}
