package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 1_000_000;
    public static final String INVALID_NUMBER_RANGE_MESSAGE_FORMAT = "입력값은 %d 이상 %d 이하의 자연수여야 합니다.";


    public static List<Integer> solution(int money) {
        isNumberInValidRange(money);

        Wallet wallet = new Wallet();
        money = wallet.changeToFiftyThousands(money);
        money = wallet.changeToTenThousands(money);
        money = wallet.changeToFiveThousands(money);
        money = wallet.changeToThousands(money);
        money = wallet.changeToFiveHundreds(money);
        money = wallet.changeToHundreds(money);
        money = wallet.changeToFifty(money);
        money = wallet.changeToTen(money);
        wallet.changeToOne(money);

        return wallet.getMoney();
    }

    private static void isNumberInValidRange(int number) {
        if (number < MIN_RANGE || MAX_RANGE < number) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_RANGE_MESSAGE_FORMAT, MIN_RANGE, MAX_RANGE));
        }
    }

    public static class Wallet {
        public Wallet() {
            this.money = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);
        }

        private final List<Integer> money;

        public List<Integer> getMoney() {
            return new ArrayList<>(money);
        }

        public int changeToFiftyThousands(int money) {
            this.money.set(0, money / 50000);
            return money % 50000;
        }

        public int changeToTenThousands(int money) {
            this.money.set(1, money / 10000);
            return money % 10000;
        }

        public int changeToFiveThousands(int money) {
            this.money.set(2, money / 5000);
            return money % 5000;
        }

        public int changeToThousands(int money) {
            this.money.set(3, money / 1000);
            return money % 1000;
        }

        public int changeToFiveHundreds(int money) {
            this.money.set(4, money / 500);
            return money % 500;
        }

        public int changeToHundreds(int money) {
            this.money.set(5, money / 100);
            return money % 100;
        }

        public int changeToFifty(int money) {
            this.money.set(6, money / 50);
            return money % 50;
        }

        public int changeToTen(int money) {
            this.money.set(7, money / 10);
            return money % 10;
        }

        public int changeToOne(int money) {
            this.money.set(8, money);
            return 0;
        }
    }
}
