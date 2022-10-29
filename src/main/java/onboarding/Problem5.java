package onboarding;

import onboarding.problem5.Bank;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int MAX_PRICE = 1000000 ;
    static final int MIN_PRICE = 1;

    public static List<Integer> solution(int money) {
        if (!validateMoney(money)) {
            return null;
        }

        List<Integer> answer = null;
        return answer;
    }

    public static boolean validateMoney(int money) {
        if (money < MIN_PRICE || money > MAX_PRICE) {
            return false;
        }
        return true;
    }
}
