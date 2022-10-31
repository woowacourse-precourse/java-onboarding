package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 오만원, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원
        int[] inTens = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int i = 0;
        while (i != 9 ) {
            answer.add(money / inTens[i]);
            money %= inTens[i];
            i++;
        }
        return answer;
    }
}
