package christmas.domain;

public enum FoodCategory {

    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료");

	private final String categoryName;

	FoodCategory(String categoryName) {
		this.categoryName = categoryName;
	}
}