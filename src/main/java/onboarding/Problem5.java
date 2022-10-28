package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return countLeastNumOfPaperAndCoin(money);
    }

    private static final int[] paperAndCoins = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    private static List<Integer> countLeastNumOfPaperAndCoin(int money) {
        List<Integer> numOfPaperAndCoin = new ArrayList<>();
        for (int paperAndCoin : paperAndCoins) {
            numOfPaperAndCoin.add(money / paperAndCoin);
            money = money % paperAndCoin;
        }

        return numOfPaperAndCoin;
    }
}
