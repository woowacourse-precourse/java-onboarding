package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> money_unit = new ArrayList<>(
            Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));// 돈 단위별로 list에 넣어놓기

        for (int i = 0; i < money_unit.size(); i++) { //반복문 진행시 각 돈 단위에 따라 처리

            int unit = money_unit.get(i);
            answer.add(money / unit);
            money = money % unit;

        }

        return answer;
    }
}
