package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int PRICE_COUNT = 9;

    public static List<Integer> solution(int money) {

        int[] priceList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        List<Integer> answer = count(priceList, money);
        return answer;
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

}
