package onboarding.problem5.collection;

import onboarding.problem5.dto.Money;
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

    public List<Integer> saveMoney(int money) {
        WalletValidator.validate(money);
        Money moneyDto = Money.of(money);

        saveAsChange(moneyDto, FIFTY_THOUSANDS);
        saveAsChange(moneyDto, TEN_THOUSANDS);
        saveAsChange(moneyDto, FIVE_THOUSANDS);
        saveAsChange(moneyDto, THOUSAND);
        saveAsChange(moneyDto, FIVE_HUNDREDS);
        saveAsChange(moneyDto, HUNDRED);
        saveAsChange(moneyDto, FIFTY);
        saveAsChange(moneyDto, TEN);
        saveAsChange(moneyDto, ONE);

        return getChanges();
    }

    private void saveAsChange(Money money, Change change) {
        changes[change.getIndex()] = money.getMoney() / change.getValue();
        money.setMoney(money.getMoney() % change.getValue());
    }
}
