package onboarding;

import java.util.Collections;
import java.util.List;

import onboarding.feature5.MoneySorter;

public class Problem5 {
    public static List<Integer> solution(int money) {
        MoneySorter moneySorter = new MoneySorter(money);
        List<Integer> answer = moneySorter.calculateNumberOfBill();
        return answer;
    }
}
