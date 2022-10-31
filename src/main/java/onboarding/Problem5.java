package onboarding;

import java.util.List;
import java.util.ArrayList;
import static onboarding.validation.NumberValidate.*;

public class Problem5 {

    public static List<Integer> solution(int money) {

        if (!rangeValidate(1, money, 1000000)) return List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);

        final List<Integer> cash = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = new ArrayList<>();

        for (Integer integer : cash) {
            answer.add(money / integer);
            money %= integer;
        }

        return answer;
    }

}
