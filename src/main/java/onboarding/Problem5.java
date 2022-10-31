package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if (money < 1 || 1_000_000 < money) {
            throw new IllegalArgumentException();
        }
        var myWallet = new Wallet(money);

        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}

class Wallet {
    private int money;
    private final Integer[] COUNT;

    Wallet(int money) {
        this.money = money;
        this.COUNT = new Integer[9];
    }
}
