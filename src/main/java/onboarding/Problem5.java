package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int PRICE_COUNT = 9;

    public static List<Integer> solution(int money) {

        int[] priceList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        try {
            validation(money);

            List<Integer> answer = count(priceList, money);
            return answer;
        } catch (RuntimeException e) {
            throw e;
        }

    }


    public static List<Integer> count(int[] priceList, int totalMoney) {
        List<Integer> countList = new ArrayList<>();

        int money = totalMoney;

        for (int i = 0; i < PRICE_COUNT; i++) {
            countList.add(money / priceList[i]);
            money = money % priceList[i];
        }

        return countList;
    }

    public static void validation(int money) {
        if (money < 1 || money > 1000000) {
            throw new RuntimeException("money 는 1이상 1,000,000 이하입니다.");
        }
    }

}
