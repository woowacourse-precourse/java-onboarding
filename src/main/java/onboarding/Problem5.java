package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> getChangeCoinList(int money, int[] coinList) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < coinList.length; i++) {
            answer.add(money / coinList[i]);
            money -= money / coinList[i] * coinList[i];
        }
        return answer;
    }

    public static List<Integer> solution(int money) {
        int coinList[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = getChangeCoinList(money, coinList);
        return answer;
    }
}
