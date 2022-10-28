package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return getCoinList(money);
    }

    public static List<Integer> getCoinList(int money) {
        Integer[] coinArray = new Integer[]{0,0,0,0,0,0,0,0,0};
        int[] coinUnitArray = getCoinUnitToArray();
        int index = 0;
        while (money > 0) {
            int coinUnit = coinUnitArray[index];
            coinArray[index] = money / coinUnit;
            money = money % coinUnit;
            index++;
        }
        return Arrays.asList(coinArray);
    }

    private static int[] getCoinUnitToArray() {
        return new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    }
}
