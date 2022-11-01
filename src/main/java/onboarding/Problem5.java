package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    static List<Integer> changeMoney(int money) {
        int currencyLenght = currency.length;
        List<Integer> account = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);
        for(int i = 0; i < currencyLenght; i++) {
            if(money / currency[i] > 0) {
                account.set(i, money / currency[i]);
                money = money - (currency[i] *  (money / currency[i]));
            }
        }

        return account;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = changeMoney(money);
        return answer;
    }
}
