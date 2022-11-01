package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return countAmountMoney(money);
    }

    public static List<Integer> countAmountMoney(int money){
        int[] amount = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> countedMoney = new ArrayList<>();

        for (int amt: amount) {
            countedMoney.add(money / amt);
            money %= amt;
        }

        return countedMoney;
    }
}
