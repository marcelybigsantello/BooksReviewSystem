package com.masantello.booksreviewsystem.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LiteraryGenre {

	ACTION(1, "Action"),
	ADVENTURE(2, "Adventure"),
	BIOGRAPHY(3, "Biography"),
	CHILDREN(4, "Children"),
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
	
	private final Integer code;
	private final String description;

	public static LiteraryGenre findByCode(Integer code) {
		for (LiteraryGenre genre : LiteraryGenre.values()) {
			if (genre.getCode().equals(code)) {
				return genre;
			}
		}
		return null;
	}
	
	public static LiteraryGenre findByDescription(String description) {
		for (LiteraryGenre genre : LiteraryGenre.values()) {
			if (genre.getDescription().equalsIgnoreCase(description)) {
				return genre;
			}
		}
		return null;
	}
	
}
