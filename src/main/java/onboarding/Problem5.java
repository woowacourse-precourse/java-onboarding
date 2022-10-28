package onboarding;

import onboarding.problem5.validation.WalletValidator;
import onboarding.problem5.collection.Wallet;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        WalletValidator.validate(money);

        Wallet wallet = Wallet.makeNewWallet();
        wallet.saveMoney(money);

        return wallet.getMoney();
    }
}
