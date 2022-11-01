package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static void main(String[] args) {
        List<Integer> moneyList = List.of(50237, 15000);
        System.out.printf("%-10s|%-30s|", "number", "result");
        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        moneyList.stream().forEach(money -> {
            System.out.printf("%-10d|%-30s|", money, solution(money));
            System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        });
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        Bank.validateMoney(money);
        answer = withdrawMoney(money);
        return answer;
    }

    private static List<Integer> withdrawMoney(int money) {
        List<Integer> wallet = new ArrayList<>();
        List<Currency> currencies = List.of(Currency.values());
        for (Currency currency : currencies) {
            wallet.add(currency.countCurrencyAmount(money));
            money = currency.calculateBalance(money);
        }
        return wallet;
    }

    enum Currency {
        FIVE_MILLION_WON_BILL(50000), ONE_MILLION_WON_BILL(10000), FIVE_THOUSAND_WON_BILL(5000),
        ONE_THOUSAND_WON(1000), FIVE_HUNDRED_WON_COIN(500), ONE_HUNDRED_WON_COIN(100),
        FIFTY_WON_COIN(50), TEN_WON_COIN(10), ONE_WON_COIN(1);

        private final int unit;

        Currency(int unit) {
            this.unit = unit;
        }

        public int countCurrencyAmount(int money) {
            return money / this.unit;
        }

        public int calculateBalance(int money) {
            return money - unit * countCurrencyAmount(money);
        }
    }

    private static class Bank {
        private static final int MIN_AMOUNT = 1;
        private static final int MAX_AMOUNT = 1_000_000;

        public static void validateMoney(int money) {
            if(checkMoneyAmount(money)) {
                throw new IllegalArgumentException("The money should be greater than or equal to 1, and less than or equal to 1,000,000.");
            }
        }

        private static boolean checkMoneyAmount(int money) {
            return money < MIN_AMOUNT || money > MAX_AMOUNT;
        }
    }
}
