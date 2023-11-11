package christmas.controller;

import java.util.ArrayList;
import java.util.List;

import christmas.domain.Benefit;
import christmas.domain.Benefits;
import christmas.domain.Food;
import christmas.domain.Foods;
import christmas.domain.VisitDate;
import christmas.service.benefit.CalcualteBenefitService;
import christmas.service.benefit.DDayDiscountService;
import christmas.service.benefit.DayOfWeekDiscountService;
import christmas.service.benefit.GiveawayEventService;
import christmas.service.benefit.SpecialDiscountService;

public class BenefitController {

	private static final int DISCOUT_CONDITION = 10_000;
	private static final int GIVEAWAY_CONDITION = 120_000;

	private final DayOfWeekDiscountService dayOfWeekDiscountService;
	private final DDayDiscountService dDayDiscountService;
	private final GiveawayEventService giveawayEventService;
	private final SpecialDiscountService specialDiscountService;
	private final CalcualteBenefitService calcualteBenefitService;

	public BenefitController() {
		this.dayOfWeekDiscountService = new DayOfWeekDiscountService();
		this.dDayDiscountService = new DDayDiscountService();
		this.giveawayEventService = new GiveawayEventService();
		this.specialDiscountService = new SpecialDiscountService();
		this.calcualteBenefitService = new CalcualteBenefitService();
	}

	public List<Benefit> getBenefits(VisitDate visitDate, Foods foods, int totalOrderPrice) {
		List<Benefit> benefits = new ArrayList<>();
		int day = visitDate.getDay();

		if (totalOrderPrice > DISCOUT_CONDITION) {
			benefits.add(getDayOfWeekBenefit(visitDate, foods));
			benefits.add(getDDayBenefit(day));
			benefits.add(getSpecialBenefit(day));
		}
		if (totalOrderPrice > GIVEAWAY_CONDITION) {
			benefits.add(getGiveawayBenefit());
		}

		return new Benefits(benefits).getNotZeroDiscountPrice();
	}

	private Benefit getDayOfWeekBenefit(VisitDate visitDate, Foods foods) {
		return dayOfWeekDiscountService.getBenefit(visitDate, foods);
	}

	private Benefit getDDayBenefit(int day) {
		return dDayDiscountService.getBenefit(day);
	}

	private Benefit getGiveawayBenefit() {
		return giveawayEventService.getBenefit();
	}

	private Benefit getSpecialBenefit(int day) {
		return specialDiscountService.getBenefit(day);
	}

	public Food getGiveaways(int totalOrderPrice) {
		if (totalOrderPrice > GIVEAWAY_CONDITION) {
			return giveawayEventService.getGiveaway();
		}
		return null;
	}

	public int getTotalDiscountPrice(List<Benefit> benefits) {
		return calcualteBenefitService.calculateTotalDiscountPrice(benefits);
	}
	
	public int getTotalBenefitPrice(int totalDiscountPrice, Food giveaway) {
		return calcualteBenefitService.calculateTotalBenefitPrice(totalDiscountPrice, giveaway);
	}
	
	public int getTotalPaymentPrice(int totalOrderPrice, int totalDiscountPrice) {
		return calcualteBenefitService.cacluclateTotalPaymentPrice(totalOrderPrice, totalDiscountPrice);
	}
}