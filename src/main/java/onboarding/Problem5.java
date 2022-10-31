package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static final int[] MONEY_UNIT = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    static final int INPUT_MINIMUM_AMOUNT = 1;
    static final int INPUT_MAXIMUM_AMOUNT = 1000000;
    static final String INPUT_TOO_SMALL_EXCEPTION = "입력한 금액이 1보다 작습니다. ";
    static final String INPUT_TOO_BIG_EXCEPTION = "입력한 금액이 1,000,000보다 큽니다. ";


    public static List<Integer> solution(int money) {
        checkMoney(money);
        return countCurrencies(money);
    }

    private static void checkMoney(int money){
        if(money < INPUT_MINIMUM_AMOUNT) inputTooSmallException();
        if(money > INPUT_MAXIMUM_AMOUNT) inputTooBigException();
    }

    private static void inputTooSmallException(){
        throw new IllegalArgumentException(INPUT_TOO_SMALL_EXCEPTION);
    }

    private static void inputTooBigException(){
        throw new IllegalArgumentException(INPUT_TOO_BIG_EXCEPTION);
    }

    private static List<Integer> countCurrencies(int money){
        List<Integer> currencies = new ArrayList<>();
        for (int currency : MONEY_UNIT) {
            currencies.add(money / currency);
            money = money % currency;
        }
        return currencies;
    }
}
