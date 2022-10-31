package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int MONEY_50000 = 50000;
    private static final int MONEY_10000 = 10000;
    private static final int MONEY_5000 = 5000;
    private static final int MONEY_1000 = 1000;
    private static final int MONEY_500 = 500;
    private static final int MONEY_100 = 100;
    private static final int MONEY_50 = 50;
    private static final int MONEY_10 = 10;
    private static final int MONEY_1 = 1;

    /**
     * @param money    : 변환할 금액
     * @param coinList : 사용 가능한 동전 리스트(내림차순)
     * @return List<Integer> : 사용한 동전 리스트
     */
    public static List<Integer> getChangeCoinList(int money, int[] coinList) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < coinList.length; i++) {
            int coinValue = coinList[i];
            if (coinValue <= 0) {
                break;
            }
            int coins = money / coinValue;
            answer.add(coins);
            money -= coins * coinValue;
        }
        return answer;
    }

    public static List<Integer> solution(int money) {
        int coinList[] = {MONEY_50000, MONEY_10000, MONEY_5000, MONEY_1000,
                MONEY_500, MONEY_100, MONEY_50, MONEY_10, MONEY_1};
        List<Integer> answer = getChangeCoinList(money, coinList);
        return answer;
    }
}
