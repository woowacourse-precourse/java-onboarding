package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static onboarding.problem5.Exchange.getExchangeList;
import static onboarding.problem5.Validation.isOutOfRange;

public class Problem5 {
    private static final int OUT_OF_RANGE = -1;

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        if (isOutOfRange(money)) {
            answer.add(OUT_OF_RANGE);
            return answer;
        }

        answer = getExchangeList(money);

        return answer;
    }
}
