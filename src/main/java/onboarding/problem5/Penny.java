package onboarding.problem5;

import java.util.List;

public enum Penny {
    FIFTY_THO(50_000),
    TENTH(10_000),
    FIVE_THO(5_000),
    THOUSAND(1_000),
    FIVE_HUNDRED(500),
    HUNDRED(100),
    FIFTY(50),
    TEN(10),
    ONE(1);
    private Integer money;

    Penny(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public static void getPennyResult(int money, List<Integer> result) {
        int share;
        for (Penny penny : Penny.values()) {
            share = getShare(money, penny);
            money = getRestMoney(share, money, penny);
            result.add(share);
        }
    }

    private static int getShare(int money, Penny penny) {
        return money / penny.money;
    }

    private static int getRestMoney(int share, int money, Penny penny) {
        if (share != 0) {
            money = money - share * penny.money;
        }
        return money;
    }
}
