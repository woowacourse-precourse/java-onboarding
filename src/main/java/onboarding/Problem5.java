package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static void main(String[] args) {
        System.out.println(solution(50237));
    }

    private static List<Integer> moneyUnit;
    private static List<Integer> moneyStorage;

    private static void initMoneyUnit() {
        moneyUnit = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        moneyStorage = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    public static List<Integer> solution(int money) {
        initMoneyUnit();
        validateMoneyUnit(money);
        return moneyStorage;
    }

    private static void validateMoneyUnit(int money) {
        for (int i = 0; i < moneyUnit.size(); i++) {
            while (true) {
                if (money / moneyUnit.get(i) > 0) {
                    moneyStorage.set(i, money / moneyUnit.get(i));
                    money %= moneyUnit.get(i);
                } else {
                    break;
                }
            }
        }
    }
}
