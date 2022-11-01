package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return countLeastNumsOfPaperAndCoin(money);
    }

    private static final int[] paperAndCoins = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    private static List<Integer> countLeastNumsOfPaperAndCoin(int money) {
        List<Integer> numsOfPaperAndCoin = new ArrayList<>();
        for (int paperAndCoin : paperAndCoins) {
            numsOfPaperAndCoin.add(money / paperAndCoin);
            money = money % paperAndCoin;
        }

        return numsOfPaperAndCoin;
    }
}
