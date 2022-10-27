package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> wallet = new ArrayList<>();
        final List<Integer> WON_LIST = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
        int wonListIndex = 0;
        for (int i = 0; i < WON_LIST.size(); i++) {
            wallet.add(money / WON_LIST.get(wonListIndex));
            money %= WON_LIST.get(wonListIndex++);
        }
        return wallet;
    }
}
