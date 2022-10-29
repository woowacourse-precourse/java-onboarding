package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> change = new ArrayList<>();
        money = toOneWon(money, change);
        toRestWon(money, change);

        return change;
    }

    public static int toOneWon(int money, List<Integer> change) {
        change.add(money % 10);
        return money / 10;
    }

    public static void toRestWon(int money, List<Integer> change) {
        for (int i = 0; i < 3; i++) {
            int oneOfNumber = money % 10;
            change.add(oneOfNumber % 5);
            change.add(oneOfNumber / 5);
            money /= 10;
        }
    }
}
