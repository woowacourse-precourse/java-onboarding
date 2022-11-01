package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        checkList(money);


    }

    public static void checkList(int money) throws IllegalArgumentException{
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException("money는 1 미만 1,000,000 초과 했다.");
        }

    }
}
