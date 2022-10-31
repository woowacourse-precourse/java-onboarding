package onboarding.support.problem5;

import java.util.ArrayList;
import java.util.List;

public class Money {
    private static final int[] moneyTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    private final List<Integer> moneyList;

    public Money(int money) {
        this.moneyList = new ArrayList<>();
        for (int type : moneyTypes) {
            int usedMoney = getUsedMoney(money, type);
            money -= usedMoney;
            this.moneyList.add(usedMoney / type);
        }
    }

    private int getUsedMoney(int money, int type) {
        return (money / type) * type;
    }

    public List<Integer> getMoneyList() {
        return moneyList;
    }
}
