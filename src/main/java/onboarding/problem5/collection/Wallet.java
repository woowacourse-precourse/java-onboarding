package onboarding.problem5.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        money = changeToFiftyThousands(money);
        money = changeToTenThousands(money);
        money = changeToFiveThousands(money);
        money = changeToThousands(money);
        money = changeToFiveHundreds(money);
        money = changeToHundreds(money);
        money = changeToFifty(money);
        money = changeToTen(money);
        changeToOne(money);
    }

    private int changeToFiftyThousands(int money) {
        this.money.set(0, money / 50000);
        return money % 50000;
    }

    private int changeToTenThousands(int money) {
        this.money.set(1, money / 10000);
        return money % 10000;
    }

    private int changeToFiveThousands(int money) {
        this.money.set(2, money / 5000);
        return money % 5000;
    }

    private int changeToThousands(int money) {
        this.money.set(3, money / 1000);
        return money % 1000;
    }

    private int changeToFiveHundreds(int money) {
        this.money.set(4, money / 500);
        return money % 500;
    }

    private int changeToHundreds(int money) {
        this.money.set(5, money / 100);
        return money % 100;
    }

    private int changeToFifty(int money) {
        this.money.set(6, money / 50);
        return money % 50;
    }

    private int changeToTen(int money) {
        this.money.set(7, money / 10);
        return money % 10;
    }

    private int changeToOne(int money) {
        this.money.set(8, money);
        return 0;
    }
}
