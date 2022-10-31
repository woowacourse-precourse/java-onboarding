package onboarding;

import java.util.ArrayList;
import java.util.List;

class Withdraw {
    int money;

    public Withdraw(int money) {
        this.money = money;
    }

    int exception() {
        if((money < 1) || (money > 1000000)) {
            return -1;
        }

        return 0;
    }

    List<Integer> change() {
        List<Integer> result = new ArrayList<>();

        result.add(money / 50000);
        money = money % 50000;
        result.add(money / 10000);
        money = money % 10000;
        result.add(money / 5000);
        money = money % 5000;
        result.add(money / 1000);
        money = money % 1000;
        result.add(money / 500);
        money = money % 500;
        result.add(money / 100);
        money = money % 100;
        result.add(money / 50);
        money = money % 50;
        result.add(money / 10);
        money = money % 10;
        result.add(money);

        return result;
    }
}
