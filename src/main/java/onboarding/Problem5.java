package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if (money < 1 || 1_000_000 < money) {
            throw new IllegalArgumentException();
        }
        var myWallet = new Wallet(money);
        return myWallet.showMeTheMoney();
    }
}

class Wallet {
    private int money;
    private final Integer[] COUNT;

    Wallet(int money) {
        this.money = money;
        this.COUNT = new Integer[9];
    }

    List<Integer> showMeTheMoney() {
        int balance = money;
        for (Currency unit : Currency.values()) {
            int count = balance / unit.value();
            int index = unit.ordinal();
            COUNT[index] = count;
            balance -= (count * unit.value());
        }
        return Arrays.asList(COUNT);
    }
}

enum Currency {
    FIFTY_THOUSAND(50_000),
    TEN_THOUSAND(10_000),
    FIVE_THOUSAND(5_000),
    THOUSAND(1_000),
    FIVE_HUNDRED(500),
    HUNDRED(100),
    FIFTY(50),
    TEN(10),
    ONE(1);

    private final int value;
    Currency(int value) {
        this.value = value;
    }

    int value() {
        return value;
    }
}
