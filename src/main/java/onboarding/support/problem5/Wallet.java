package onboarding.support.problem5;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final List<Integer> moneyCounts;

    public Wallet(int money) {
        moneyCounts = new ArrayList<>();
        for (MoneyType type : MoneyType.values()) {
            int usedMoney = getUsedMoney(money, type.getMoney());
            money -= usedMoney;
            moneyCounts.add(usedMoney / type.getMoney());
        }
    }

    private int getUsedMoney(int money, int type) {
        return (money / type) * type;
    }

    public List<Integer> getMoneyCounts() {
        return moneyCounts;
    }
}
