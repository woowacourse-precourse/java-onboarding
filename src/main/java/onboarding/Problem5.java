package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 지폐 리스트 생성
 */
public class Problem5 {
    private static final int[] cashes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for(int cash : cashes){
            int cnt = money / cash;
            money %= cash;
            answer.add(cnt);
        }
        return answer;
    }
}
