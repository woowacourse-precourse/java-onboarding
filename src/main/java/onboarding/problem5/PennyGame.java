package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class PennyGame {
    private static final int MIN = 1;
    private static final int MAX = 1_000_000;

    public static List<Integer> start(int money) {
        checkInput(money);
        List<Integer> result = new ArrayList<>();
        Penny.getPennyResult(money, result);
        return result;
    }

    private static void checkInput(int money) {
        checkMin(money);
        checkMax(money);
    }

    private static void checkMax(int money) {
        if (money > MAX) {
            throw new PennyException("최대 입력 가능 숫자는 1_000_000 입니다.");
        }
    }

    private static void checkMin(int money) {
        if (money < MIN) {
            throw new PennyException("최소 1 이상의 금액을 입력해주세요.");
        }
    }
}
