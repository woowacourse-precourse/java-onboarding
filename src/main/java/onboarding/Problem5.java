package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        /* 문제에 제시 된 것처럼 5만원,만원,5천원 등등등 배열 생성 */
        int[] count = {50000,10000,5000,1000,500,100,50,10,1};
        int result = 0;

        /* 5만원부터 나눈 값을 저장하고,
        나머지로 money값을 다시 정의한다. */
        for (int i = 0; i < count.length; i++) {
            result = money / count[i];
            answer.add(result);
            money = money % count[i];
        }
        return answer;
    }
}
