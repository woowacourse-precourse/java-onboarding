package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {

        Money input = new Money(money);

        Coins coins = new Coins();
        coins.changeCoin(input);

        return coins.getCoins();
    }
}

class Coins {

    private final int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    private final List<Integer> coins = new ArrayList<>();

    public Coins(){}

    public void changeCoin(Money money) {
        int remain = money.getMoney();
        for (int change : unit) {
            // 현재 금액권으로 해결할 수 있는 돈
            int count = remain / change;
            coins.add(count);
            // 나머지 금액
            remain = remain % change;
        }
    }

    public int getCount() {
        return this.unit.length;
    }

    public List<Integer> getCoins() {
        return this.coins;
    }

}


class Money {

    private final int money;

    public Money(int money){
        validateSize(money);
        this.money = money;
    }

    private void validateSize(int money) {
        if (money < 1) {
            throw new IllegalArgumentException("0원 이하는 입력할 수 없습니다.");
        }
        if (money > 1000000) {
            throw new IllegalArgumentException("1000000원 이하로 입력해주세요.");
        }
    }

    public int getMoney() {
        return this.money;
    }
}

