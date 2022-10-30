package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        final int[] typeOfMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        return changeMoney(typeOfMoney, money);

    }

    //돈 소분 기능
    public static List<Integer> changeMoney(int[] typeOfMoney, int money) {
        List<Integer> answer = new ArrayList<>();
        //큰 돈부터 작은 돈까지 차례대로 계산한다.
        for (int i = 0; i < typeOfMoney.length; i++) {
            int cnt = money / typeOfMoney[i];
            answer.add(cnt);
            money %= typeOfMoney[i];
        }
        return answer;
    }
}
