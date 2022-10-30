package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
* 1. 각 금액을 가진 리스트 생성
* 2. 금액이 큰 순서부터 돈을 나누기 연산한 몫을 결과 리스트에 넣고 나머지 연산을 통해 현재 돈을 갱신
*/

public class Problem5 {
    private static final List<Integer> units = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int unit : units) {
            answer.add(money / unit);
            money %= unit;
        }

        return answer;
    }
}
