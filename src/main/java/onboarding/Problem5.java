package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> change = new ArrayList<>();
        money = toOneWon(money, change);
        money = toRestWon(money, change);
        toFinalWon(money, change);
        Collections.reverse(change);
        return change;
    }

    public static int toOneWon(int money, List<Integer> change) {
        change.add(money % 10);
        return money / 10;
    }

    public static int toRestWon(int money, List<Integer> change) {
        for (int i = 0; i < 3; i++) {
            int oneOfNumber = money % 10;
            change.add(oneOfNumber % 5);
            change.add(oneOfNumber / 5);
            money /= 10;
        }
        return money;
    }
    public static void toFinalWon(int money, List<Integer> change){
        change.add(money % 5);
        change.add(money / 5);
    }
}
