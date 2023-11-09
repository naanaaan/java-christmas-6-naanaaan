package christmas.domain;

public record Food(FoodCategory foodCategory, String name, int price) {

	public Food {
		validate(name);
	}

	private void validate(String name) {
		validateExistenceCheck(name);
	}

	private void validateExistenceCheck(String name) {
		if (!Menu.checkByName(name)) {
			throw new IllegalArgumentException();
		}
	}
}