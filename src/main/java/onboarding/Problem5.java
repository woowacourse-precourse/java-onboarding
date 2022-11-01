package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] unit = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
        answer = calculateExchange(money, unit);

        return answer;
    }

    /**
     * @param money : 자연수
     * @param unit : 자연수 배열(돈의 단위 이므로 큰 순서대로 넣을 것)
     * @return unit의 배열 순서대로 리스트에 담아 개수를 반환
     */
    public static List<Integer> calculateExchange(int money, int[] unit){
        int count = 0;
        List<Integer> result = new ArrayList<>();

        for(int i=0; unit.length > i; i++){
            result.add(money/unit[i]);
            money %= unit[i];
        }

        return result;
    }
}
