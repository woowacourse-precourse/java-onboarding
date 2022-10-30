package onboarding.problem5.domain;

import java.util.HashMap;

import static onboarding.problem5.domain.Money.DEFAULT_MONIES;

public class Wallet {

    private final HashMap<Money, Integer> moneyMap;

    public Wallet() {
        this.moneyMap = new HashMap<>();

        // 지갑 안에 들어있는 화폐 개수 0개로 초기화
        DEFAULT_MONIES.forEach(money -> moneyMap.put(money, 0));
    }

    public void add(Money money, int count) {
        moneyMap.put(money, moneyMap.get(money) + count);
    }

    public Integer get(Money money) {
        return moneyMap.get(money);
    }
}
