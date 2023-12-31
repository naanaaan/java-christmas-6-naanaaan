package christmas.util;

public enum ErrorMessage {

	VALID_VISITDATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."), 
	VALID_ORDER_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
	ORDER_NUMBER("최대 주문수는 %d입니다. 다시 입력해 주세요."),
	ONLY_BEVERAGE("음료수만 시킬 수 없습니다. 다시 입력해 주세요."),
	PREFIX("[ERROR] ");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX.message + message;
	}
}