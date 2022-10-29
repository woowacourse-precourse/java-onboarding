package onboarding.problem5.domain;

import java.util.ArrayList;
import java.util.List;

public class KoreanCurrencyExchangeStrategy implements CurrencyExchangeStrategy {

    private static final List<Integer> koreanCurrencys;
    private static final int CAN_NOT_DIVIDE = 0;

    static {
        koreanCurrencys = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
    }

    @Override
    public List<Integer> exchange(int money) {
        List<Integer> result = new ArrayList<>();
        koreanCurrencys.stream()
                .reduce(money, (total, currency) -> {
                    result.add(divide(total, currency));
                    return change(total, currency);
                });
        return result;
    }

    private int divide(int dividend, int divisor) {
        if (canNotDivide(dividend, divisor)) {
            return CAN_NOT_DIVIDE;
        }
        return dividend / divisor;
    }

    private static boolean canNotDivide(int dividend, int divisor) {
        return dividend < divisor;
    }

    private int change(Integer total, Integer currency) {
        return total % currency;
    }
}
