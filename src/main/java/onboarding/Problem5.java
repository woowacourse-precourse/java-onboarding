package onboarding;

import static onboarding.Problem5.MoneyCalculator.calculateMoneyCount;
import static onboarding.Problem5.MoneyConst.FIFTY_THOUSAND_WON;
import static onboarding.Problem5.MoneyConst.FIFTY_WON;
import static onboarding.Problem5.MoneyConst.FIVE_HUNDRED_WON;
import static onboarding.Problem5.MoneyConst.FIVE_THOUSAND_WON;
import static onboarding.Problem5.MoneyConst.ONE_HUNDRED_WON;
import static onboarding.Problem5.MoneyConst.ONE_THOUSAND_WON;
import static onboarding.Problem5.MoneyConst.ONE_WON;
import static onboarding.Problem5.MoneyConst.TEN_THOUSAND_WON;
import static onboarding.Problem5.MoneyConst.TEN_WON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        return calculateMoneyCount(money);
    }

    public static class MoneyCalculator {

        public static List<Integer> calculateMoneyCount(int money) {
            int[] moneyTypes = {FIFTY_THOUSAND_WON, TEN_THOUSAND_WON, FIVE_THOUSAND_WON,
                ONE_THOUSAND_WON, FIVE_HUNDRED_WON, ONE_HUNDRED_WON, FIFTY_WON, TEN_WON, ONE_WON};
            List<Integer> result = new ArrayList<>();

            for (int i : moneyTypes) {
                result.add(money / i);
                money %= i;
            }
            return result;
        }
    }

    public abstract class MoneyConst {

        public static final int FIFTY_THOUSAND_WON = 50000;
        public static final int TEN_THOUSAND_WON = 10000;
        public static final int FIVE_THOUSAND_WON = 5000;
        public static final int ONE_THOUSAND_WON = 1000;
        public static final int FIVE_HUNDRED_WON = 500;
        public static final int ONE_HUNDRED_WON = 100;
        public static final int FIFTY_WON = 50;
        public static final int TEN_WON = 10;
        public static final int ONE_WON = 1;
    }
}
