package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    static List<Integer> answer;
    static int[] moneyArr;

    static void input() {
        answer = new ArrayList<>();
        moneyArr = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    }

    private static void validateMoney(int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException("money는 1 이상 1,000,000 이하인 자연수입니다.");
        }
    }

    public static List<Integer> solution(int money) {
        validateMoney(money);
        input();
        return new ArrayList<>();
    }
}
