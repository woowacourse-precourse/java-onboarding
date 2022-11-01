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

    public static void countMoney(int money) {
        for (int i = 0; i < monetaryUnit.length; i++) {
            countPaperMoney[i] = money / monetaryUnit[i];
            money %= monetaryUnit[i];
        }
    }

    public static boolean moneyOutOfRangeException(int money) {
        if (money < 1 || money > 1_000_000) {
            System.out.println("돈의 범위는 1원부터 1,000,000원까지 입니다.");
            return true;
        }
        return false;
    }
}