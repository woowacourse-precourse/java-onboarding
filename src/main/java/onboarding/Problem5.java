package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return getCoinNum(money);
    }

    private static List<Integer> getCoinNum(int money) {

        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int quotient;

        Integer[] number = new Integer[9];

        for (int i = 0; i < coin.length; i++) {
            quotient = money / coin[i];
            number[i] = quotient;
            money -= quotient * coin[i];
        }

        return Arrays.asList(number);
    }
}
