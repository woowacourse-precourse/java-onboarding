package onboarding.problem5.collection;

import onboarding.problem5.validation.WalletValidator;
import onboarding.problem5.vo.Change;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static onboarding.problem5.vo.Change.*;

public class Wallet {
    private final int[] changes;

    public Wallet() {
        this.changes = new int[9];
    }

    public static Wallet makeNewWallet() {
        return new Wallet();
    }

    public List<Integer> getChanges() {
        return Arrays.stream(changes).boxed().collect(Collectors.toList());
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
        changes[change.getIndex()] = money / change.getValue();
        return money % change.getValue();
    }
}
