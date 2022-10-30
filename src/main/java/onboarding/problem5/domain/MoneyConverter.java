package onboarding.problem5.domain;

import static onboarding.problem5.domain.Money.DEFAULT_MONIES;

public class MoneyConverter {

    public Wallet convert(Money target) {
        Wallet wallet = new Wallet();

        for (Money money : DEFAULT_MONIES) {
            wallet.add(money, target.divide(money));
            target = target.remainder(money);
        }
        return wallet;
    }
}
