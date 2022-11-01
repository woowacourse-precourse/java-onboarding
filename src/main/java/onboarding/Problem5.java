package onboarding;

import java.util.*;

public class Problem5 {

    public static List<Integer> converMoney(int money) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < moneyArr.length; i++) {
            answer.add(money / moneyArr[i]);
            money %= moneyArr[i];
        }

        return answer;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = converMoney(money);
        return answer;
    }


}
