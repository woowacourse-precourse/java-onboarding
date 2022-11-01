package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static int totalMoney;
    public static final int[] won = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        totalMoney = money;
        List<Integer> problemFiveAnswer = exchangeMoney();
        return problemFiveAnswer;
    }

    public static List<Integer> exchangeMoney() {
        Integer[] exchangedMoney = new Integer[9];
        for (int i = 0; i < 9; i++) {
            exchangedMoney[i] = 0;
            exchangedMoney[i] += exchange(i);
        }
        return Arrays.asList(exchangedMoney);
    }

    public static int exchange(int index) {
        if(totalMoney < won[index]) {
            return 0;
        }

        int numMoney = totalMoney / won[index];
        totalMoney = totalMoney - won[index] * numMoney;
        return numMoney;
    }
}
