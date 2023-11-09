package christmas.calculator;

public interface Calculator<T extends Number, U> {

	T calculateSum(U data);
}