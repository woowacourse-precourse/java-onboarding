package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 1. 화폐 금액 타입 리스트 내림차순 선언
        List<Integer> types = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        // 2. 각 금액이 반환될 수 있는 최대 갯수 구하기
        for(int type : types) {
            int cnt = money / type;
            answer.add(cnt);
            money -= type * cnt;
        }

        return answer;
    }
}
