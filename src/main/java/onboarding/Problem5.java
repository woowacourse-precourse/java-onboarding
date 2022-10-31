package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final int MINIMUN_INPUT = 1;
    private static final int MAXIMUM_INPUT = 1000000;
    private static final List<Integer> INPUT_ERROR = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);
    private static final List<Integer> MONEY_KIND = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1, 0);

    public static List<Integer> solution(int money) {
        if (isExceptionInput(money)) return INPUT_ERROR;

        return changeMoney(money, new ArrayList<>());
    }

    private static List<Integer> changeMoney(int money, List<Integer> changes) {
        int money_kind = getMoneyKind(changes);

        if (money_kind == 0) return changes;

        changes.add(money / money_kind);

        return changeMoney(money % money_kind, changes);
    }

    private static int getMoneyKind(List<Integer> changes) {
        int index = changes.size();
        int money_kind = MONEY_KIND.get(index);

        return money_kind;
    }

    private static boolean isExceptionInput(int money) {
        return money < MINIMUN_INPUT || money > MAXIMUM_INPUT;
    }
}
