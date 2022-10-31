package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 오만, 만, 오천, 천, 오백, 백, 오십, 십, 일
        List<Integer> answer = new ArrayList<>();
        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i<coin.length; i++){
            int tmp = money / coin[i];
            answer.add(tmp);
            money = money - (tmp * coin[i]);
        }

        return answer;
    }
}
