package christmas.domain.food;

public class Food {

	private final FoodCategory foodCategory;
	private final String foodName;
	private final int foodPrice;

	public Food(FoodCategory foodCategory, String foodName, int foodPrice) {
		this.foodCategory = foodCategory;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}

	public boolean checkCategory(FoodCategory categoryToCheck) {
		return foodCategory == categoryToCheck;
	}

	public String getFoodName() {
		return foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}
}