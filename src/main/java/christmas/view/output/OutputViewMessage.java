package christmas.view.output;

public enum OutputViewMessage {
	
    GREETING("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    EVENT_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),
    TOTAL_ORDER_PRICE_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    EVENT_PRODUCTS("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFITS_PRICE("<총혜택 금액>"),
    TOTAL_PAYMENT_PRICE_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>"),
	NOTHING("없음");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}