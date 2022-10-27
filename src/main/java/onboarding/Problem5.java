package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static void validateMoney(int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException("money는 1 이상 1,000,000 이하인 자연수입니다.");
        }
    }

    public static List<Integer> solution(int money) {
        validateMoney(money);
        return new ArrayList<>();
    }
}
