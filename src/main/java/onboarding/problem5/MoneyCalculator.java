package onboarding.problem5;

import static onboarding.problem5.consts.MoneyConst.FIFTY_THOUSAND_WON;
import static onboarding.problem5.consts.MoneyConst.FIFTY_WON;
import static onboarding.problem5.consts.MoneyConst.FIVE_HUNDRED_WON;
import static onboarding.problem5.consts.MoneyConst.FIVE_THOUSAND_WON;
import static onboarding.problem5.consts.MoneyConst.ONE_HUNDRED_WON;
import static onboarding.problem5.consts.MoneyConst.ONE_THOUSAND_WON;
import static onboarding.problem5.consts.MoneyConst.ONE_WON;
import static onboarding.problem5.consts.MoneyConst.TEN_THOUSAND_WON;
import static onboarding.problem5.consts.MoneyConst.TEN_WON;

import java.util.ArrayList;
import java.util.List;

public class MoneyCalculator {

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