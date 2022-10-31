package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    // 몫 구하는 함수
    public static int divide(int money, int type) {
        return money / type;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 각 지폐 종류를 담은 리스트 생성
        List<Integer> type = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        // 지폐 종류별로 돌며 몫을 정답리스트에 넣고, 그만큼 money 에서 빼줌
        for (int t:type) {
            int quot = divide(money, t);

            answer.add(quot);
            money -= quot * t;
        }

        return answer;
    }
}
