package christmas.domain.food;

public class Food {

	private final FoodCategory foodCategory;
	private final String name;
	private final int price;

	public Food(FoodCategory foodCategory, String name, int price) {
		this.foodCategory = foodCategory;
		this.name = name;
		this.price = price;
	}

	public boolean checkCategory(FoodCategory categoryToCheck) {
		return foodCategory == categoryToCheck;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}
