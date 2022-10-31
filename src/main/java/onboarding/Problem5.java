package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    // Hard coding
    private static final int[] currency = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(9);

        int rest = money;

        for (int i = 0; i < currency.length; i++){
            int cnt = 0;

            // i번째 지폐/동전을 최대한 쓰고, 쓴 만큼 rest를 업데이트한다.
            if (rest >= currency[i]){
                cnt = rest / currency[i];
                rest %= currency[i];
            }

            answer.add(cnt);
        }

        return answer;
    }
}
