package onboarding;

import onboarding.problem5.collection.Wallet;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Wallet wallet = Wallet.makeNewWallet();
        return wallet.saveMoney(money);
    }
}
