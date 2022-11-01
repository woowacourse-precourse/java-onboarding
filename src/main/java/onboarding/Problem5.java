package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        validate(money);
        ArrayList<Integer> moneyUnits = new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        ArrayList<Integer> wallet = new ArrayList<>();
        for (int each : moneyUnits) {
            wallet.add(money / each);
            money %= each;
        }
        return wallet;
    }

    private static void validate(int money) {
        if(money < 1 || money > 1_000_000) {
            System.out.println("입력값의 범위가 잘못되었습니다");
        }
    }
}
