package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        answer.add(Math.floorDiv(money, 50000));
        money = Math.floorMod(money, 50000);

        answer.add(Math.floorDiv(money, 10000));
        money = Math.floorMod(money, 10000);

        answer.add(Math.floorDiv(money, 5000));
        money = Math.floorMod(money, 5000);

        answer.add(Math.floorDiv(money, 1000));
        money = Math.floorMod(money, 1000);

        answer.add(Math.floorDiv(money, 500));
        money = Math.floorMod(money, 500);

        answer.add(Math.floorDiv(money, 100));
        money = Math.floorMod(money, 100);

        answer.add(Math.floorDiv(money, 50));
        money = Math.floorMod(money, 50);

        answer.add(Math.floorDiv(money, 10));
        answer.add(Math.floorMod(money, 10));

        return answer;
    }
}
