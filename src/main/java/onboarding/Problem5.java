package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final List<Integer> UNIT_OF_WON = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> wallet = new ArrayList<>();
        for (int unitOfMoney : UNIT_OF_WON) {
            wallet.add(money / unitOfMoney);
            money = money % unitOfMoney;
        }
        return wallet;
    }
}

