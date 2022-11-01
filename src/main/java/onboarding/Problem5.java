package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> result = new ArrayList<>();
        changeMoney(money, result);
        return result;
    }

    private static void changeMoney(int money, List<Integer> result) {
        result.add(change50000(money));
        money -= 50000 * change50000(money);

        result.add(change10000(money));
        money -= 10000 * change10000(money);

        result.add(change5000(money));
        money -= 5000 * change5000(money);

        result.add(change1000(money));
        money -= 1000 * change1000(money);

        result.add(change500(money));
        money -= 500 * change500(money);

        result.add(change100(money));
        money -= 100 * change100(money);

        result.add(change50(money));
        money -= 50 * change50(money);

        result.add(change10(money));
        money -= 10 * change10(money);

        result.add(change1(money));
        money -= 1 * change1(money);

    }

    private static int change1(int money) {
        if (money / 1 != 0) return money / 1;
        return 0;
    }

    private static int change10(int money) {
        if (money / 10 != 0) return money / 10;
        return 0;
    }

    private static int change50(int money) {
        if (money / 50 != 0) return money / 50;
        return 0;
    }

    private static int change100(int money) {
        if (money / 100 != 0) return money / 100;
        return 0;
    }

    private static int change500(int money) {
        if (money / 500 != 0) return money / 500;
        return 0;
    }

    private static int change1000(int money) {
        if (money / 1000 != 0) return money / 1000;
        return 0;
    }

    private static int change5000(int money) {
        if (money / 5000 != 0) return money / 5000;
        return 0;
    }

    private static int change10000(int money) {
        if (money / 10000 != 0) return money / 10000;
        return 0;
    }

    private static int change50000(int money) {
        if (money / 50000 != 0) return money / 50000;
        return 0;
    }
}
