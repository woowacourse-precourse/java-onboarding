package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        //화폐 개수 계산 기능
        for (int data : unit) {
            answer.add(money / data);
            money = money % data;
        }

        return answer;
    }
}
