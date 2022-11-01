package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static final int[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    static Integer[] countPaperMoney = new Integer[9];
    static List<Integer> countPaperMoneyList = new ArrayList<>();

    public static List<Integer> solution(int money) {
        if (moneyOutOfRangeException(money)) {
            Arrays.fill(countPaperMoney, 0);
            return countPaperMoneyList = Arrays.asList(countPaperMoney);
        }
        countMoney(money);
        return countPaperMoneyList = Arrays.asList(countPaperMoney);
    }
}