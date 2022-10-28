package onboarding.problem5.collection;

import onboarding.problem5.validation.WalletValidator;
import onboarding.problem5.vo.Change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static onboarding.problem5.vo.Change.*;

public class Wallet {
    private final List<Integer> money;

    public Wallet(List<Integer> money) {
        this.money = money;
    }

    public static Wallet makeNewWallet() {
        return new Wallet(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    public List<Integer> getMoney() {
        return new ArrayList<>(money);
    }

    public void saveMoney(int money) {
        WalletValidator.validate(money);

        money = saveAsChange(money, FIFTY_THOUSANDS);
        money = saveAsChange(money, TEN_THOUSANDS);
        money = saveAsChange(money, FIVE_THOUSANDS);
        money = saveAsChange(money, THOUSAND);
        money = saveAsChange(money, FIVE_HUNDREDS);
        money = saveAsChange(money, HUNDRED);
        money = saveAsChange(money, FIFTY);
        money = saveAsChange(money, TEN);
        saveAsChange(money, ONE);
    }

    private int saveAsChange(int money, Change change) {
        this.money.set(change.getIndex(), money / change.getValue());
        return money % change.getValue();
    }
}
