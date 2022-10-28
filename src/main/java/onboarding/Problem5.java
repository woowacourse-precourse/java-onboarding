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
        List<Integer> monetary = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int i = 0; i < monetary.size(); i++) {
            answer.add(money / monetary.get(i));
            money %= monetary.get(i);
        }
        return answer;
    }
}
