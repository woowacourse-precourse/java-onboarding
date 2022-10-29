package onboarding.promble5;

import java.util.HashMap;

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
}
