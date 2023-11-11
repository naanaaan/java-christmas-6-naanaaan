package christmas.domain.food;

import java.util.Arrays;
import java.util.Optional;

public enum FoodMenu {

	MUSHROOM_SOUP(FoodCategory.APPETIZER, "양송이수프", 6_000),
	TAPAS(FoodCategory.APPETIZER, "타파스", 5_500),
	CAESAR_SALAD(FoodCategory.APPETIZER, "시저샐러드", 8_000),

	T_BONE_STEAK(FoodCategory.MAIN, "티본스테이크", 55_000),
	BBQ_RIBS(FoodCategory.MAIN, "바비큐립", 54_000),
	SEAFOOD_PASTA(FoodCategory.MAIN, "해산물파스타", 35_000),
	CHRISTMAS_PASTA(FoodCategory.MAIN, "크리스마스파스타", 25_000),

	CHOCO_CAKE(FoodCategory.DESSERT, "초코케이크", 15_000), 
	ICE_CREAM(FoodCategory.DESSERT, "아이스크림", 5_000),

	ZERO_COLA(FoodCategory.BEVERAGE, "제로콜라", 3_000),
	RED_WINE(FoodCategory.BEVERAGE, "레드와인", 60_000),
	CHAMPAGNE(FoodCategory.BEVERAGE, "샴페인", 25_000);

	private final FoodCategory category;
	private final String name;
	private final int price;

	FoodMenu(FoodCategory category, String name, int price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public static boolean checkByName(String name) {
		return Arrays.stream(values())
				.anyMatch(menu -> menu.name.equals(name));
	}

	public static Optional<FoodMenu> getMenuByName(String name) {
	    return Arrays.stream(values())
	            .filter(menu -> menu.name.equals(name))
	            .findFirst();
	}

	public Food toFood() {
		return new Food(category, name, price);
	}

	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}