package onboarding;

import java.util.List;
import java.util.ArrayList;
import static onboarding.validation.NumberValidate.*;

public class Problem5 {
    static final List<Integer> cash = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    private static boolean validateProblem(int money){
        return rangeValidate(1, money, 1000000);
    }

    public static List<Integer> solution(int money) {

        if (!validateProblem(money)) return null;

        List<Integer> answer = new ArrayList<>();

        for (Integer integer : cash) {
            answer.add(money / integer);
            money %= integer;
        }

        return answer;
    }

}
