package onboarding;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/*
문제 설명
- 큰 금액의 화폐 위주로 받아 지갑을 최대한 가볍도록 만들어야 한다.
- 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 반환해야 한다.
*/

/*
기능 목록
- 큰 금액의 화폐 우선으로 담아 리스트에 개수 담기
*/

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 자바의 List에 대한 지식이 부족해 일단 아래와 같은 방식으로 일일이 초기화했다.
        List<Integer> money_unit = List.of(50000, 10000, 5000, 1000, 500, 100 ,50, 10, 1);
        List<Integer> answer = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));

        for (int i = 0; i < money_unit.size(); i++) {
            int num = money / money_unit.get(i);
            answer.set(i, num);

            money %= money_unit.get(i);
        }

        return answer;
    }
}
