package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 📚 기능 목록
 *
 * 1. 주어진 수를 각 단위별로 구분하는 기능
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> monetaryList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (Integer monetary : monetaryList) {
            answer.add(money / monetary);
            money %= monetary;
        }
        return answer;
    }
}
