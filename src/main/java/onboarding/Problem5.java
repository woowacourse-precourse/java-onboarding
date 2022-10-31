package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        /* 문제에서 주어진 화폐 단위 목록 */
        List<Integer> unitList = new ArrayList<>(
                Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
        );

        List<Integer> answer = new ArrayList<>();
        for (Integer unit: unitList) {      // 각 화폐 단위별로
            answer.add(money / unit);       // money를 현재 화폐단위로 나눈 몫
            money = money % unit;           // money를 현재 화폐단위로 나눈 나머지로 갱신
        }

        return answer;
    }
}
