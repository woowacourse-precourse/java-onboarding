package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> unit = List.of(50000,10000,5000,1000,500,100,50,10,1);  // 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원

        // 큰 화폐부터 차례로 나눠서 값을 대입한다. (큰 화폐는 모두 그보다 작은 화폐의 배수이기 때문에 차례로 나눠도 됨)
        for(Integer u : unit) {
            int quotient = money / u;
            answer.add(quotient);
            money = money - (quotient * u);  // 몫을 구하고나서 남은 돈을 계산한다.
        }
        return answer;
    }
}
