package christmas.controller;

import java.util.List;

import christmas.domain.Food;
import christmas.domain.Foods;
import christmas.domain.VisitDate;
import christmas.service.benefit.DDayDiscountService;
import christmas.service.benefit.DayOfWeekDiscountService;
import christmas.service.benefit.GiveawayEventService;
import christmas.service.benefit.SpecialDiscountService;

public class BenefitController {

	private final DayOfWeekDiscountService dayOfWeekDiscountService;
	private final DDayDiscountService dDayDiscountService;
	private final GiveawayEventService giveawayEventService;
	private final SpecialDiscountService specialDiscountService;

	public BenefitController() {
		this.dayOfWeekDiscountService = new DayOfWeekDiscountService();
		this.dDayDiscountService = new DDayDiscountService();
		this.giveawayEventService = new GiveawayEventService();
		this.specialDiscountService = new SpecialDiscountService();
	}

	public int getTotalBenefitsAmount(VisitDate visitDate, Foods foods, int totalOrderAmount) {
		int totalBenefitsAmount = 0;
		int day = visitDate.getDay();

		if (totalOrderAmount >= 100000) {
			totalBenefitsAmount = getDayOfWeekDiscount(visitDate, foods) + getDDayDiscount(day)
					+ getSpecialDiscount(day);
		}

		if (totalOrderAmount >= 120000) {
			List<Food> eventProducts = getEventProducts();
			totalBenefitsAmount += getSumEventProductPrice(eventProducts);
		}

		return totalBenefitsAmount;
	}

	public int getDayOfWeekDiscount(VisitDate visitDate, Foods foods) {
		return dayOfWeekDiscountService.discount(visitDate, foods);
	}

	public int getDDayDiscount(int day) {
		return dDayDiscountService.discount(day);
	}

	public List<Food> getEventProducts() {
		return giveawayEventService.giveEventProduct();
	}

	public int getSumEventProductPrice(List<Food> eventProducts) {
		return giveawayEventService.calculateSumEventProductPrice(eventProducts);
	}

	public int getSpecialDiscount(int day) {
		return specialDiscountService.discount(day);
	}

}