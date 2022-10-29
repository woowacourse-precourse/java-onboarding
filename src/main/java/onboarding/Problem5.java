package onboarding;

import onboarding.problem5.Problem5Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private final static int MIN_INPUT = 1;
    private final static int MAX_INPUT = 1000000;

    private final static List<Integer> MONEY_LIST = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {

        List<Integer> answer = Collections.emptyList();

        if (Problem5Validation.problem5InputValidation(money, MIN_INPUT,MAX_INPUT)) {
            moneyCount(answer, money);
        } else {
            for (int i = 0; i < MONEY_LIST.size(); i++) {
                answer.add(0);
            }
        }
        return answer;

    }

    private static void moneyCount(List<Integer> answer, int money) {
        for (int i = 0; i < MONEY_LIST.size(); i++) {
            int quotient = quotientOfMoneyIs(MONEY_LIST.get(i), money);
            money %= MONEY_LIST.get(i);
            answer.add(quotient);
        }
    }

    private static int quotientOfMoneyIs(Integer money, int typeOfCurrency) {
        return 0;
    }
}
