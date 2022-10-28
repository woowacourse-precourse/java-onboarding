package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();

        final int[] typeOfMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        changeMoney(typeOfMoney, answer, money);

        return answer;
    }

    public static void changeMoney(int[] typeOfMoney, List<Integer> answer, int money) {
        //큰 돈부터 작은 돈까지 차례대로 계산한다.
        for(int i = 0; i < typeOfMoney.length; i++) {
            int cnt = money / typeOfMoney[i];
            if(cnt != 0) {
                answer.add(cnt);
                money -= cnt*typeOfMoney[i];
            }else {
                answer.add(cnt);
            }
        }
    }
}
