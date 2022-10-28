package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Problem5 {
    public static List<Integer> calcMoneyUnit(int money) {
        // 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
        List<Integer> moneyUnit = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
        List<Integer> moneyUnitNum = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);

        return moneyUnitNum;
    }


    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        System.out.println(answer);

        return answer;
    }
}
