package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static int[] unit = { 50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1 }; //화폐 단위

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int u : unit) {
            answer.add(money / u);
            money %= u;
        }

        return answer;
    }
}
