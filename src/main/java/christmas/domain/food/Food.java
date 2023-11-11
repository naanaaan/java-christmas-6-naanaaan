package christmas.domain.food;

public record Food(FoodCategory foodCategory, String name, int price) {

	public boolean checkCategory(FoodCategory categoryToCheck) {
		if (foodCategory == categoryToCheck) {
			return true;
		}

		return false;
	}
}