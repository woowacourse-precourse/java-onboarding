package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static List<Integer> getCoinList(int money) {
        List<Integer> coinList = Collections.emptyList();
        int[] coinUnitArray = getCoinUnitToArray();
        int index = 0;
        while (money > 0) {
            int coinUnit = coinUnitArray[index];
            coinList.add(money / coinUnit);
            money = money % coinUnit;
        }
        return coinList;
    }

    private static int[] getCoinUnitToArray() {
        return new int[]{50000,10000,5000,1000,500,100,50,10,1};
    }
}
