package onboarding;

import onboarding.problem5.Problem5Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 1000000;

    private static final List<Integer> MONEY_LIST = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {

        List<Integer> result = new ArrayList<>();

        if (Problem5Validation.problem5InputValidation(money, MIN_INPUT,MAX_INPUT)) {
            moneyCount(result, money);
            return result;
        }
        List<Integer> answer = Collections.emptyList();
        return answer;



    }

    private static void moneyCount(List<Integer> result, int money) {
        for (int i = 0; i < MONEY_LIST.size(); i++) {
            int quotient = quotientOfMoneyIs(money,MONEY_LIST.get(i));
            money %= MONEY_LIST.get(i);
            result.add(quotient);
        }
    }

    private static int quotientOfMoneyIs(Integer money, int typeOfCurrency) {
        return money / typeOfCurrency;
    }
}
