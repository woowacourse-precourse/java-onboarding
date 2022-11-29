package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class Exchanger {

    private static final List<Integer> CHANGE_LIST = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    private static final int MAX_VALUE = 1_000_000;
    private static final int MIN_VALUE = 1;

    private Exchanger() {}

    public static List<Integer> exchange(int money) {

        validateMoney(money);

        List<Integer> changeList = new ArrayList<>();

        for (Integer change : CHANGE_LIST) {
            changeList.add(money / change);
            money = money % change;
        }
        return changeList;
    }

    private static void validateMoney(int money) {
        if (money < MIN_VALUE || money > MAX_VALUE) {
            throw new RuntimeException("1 이상 1,000,000 이하의 값만 입력 가능합니다.");
        }
    }
}
