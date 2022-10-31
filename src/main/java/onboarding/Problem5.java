package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        //오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
        List<Integer> moneyValue = new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        for (Integer integer: moneyValue) {
            //금액이 변환되면 갯수만큼 넣어주고, 현재금액을 남은금액으로 바꿔준다.
            if (money/integer >= 1) {
                answer.add(money/integer);
                money = money%integer;
            }
            else answer.add(0);
        }

        return answer;
    }
}
