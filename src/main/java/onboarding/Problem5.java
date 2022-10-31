package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static int[] moneyCurrency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < moneyCurrency.length; i++) {
            int count = money / moneyCurrency[i];
            answer.add(count);
            money = money % moneyCurrency[i];
        }
        return answer;
    }
}
