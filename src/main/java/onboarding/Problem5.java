package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    final static int FIFTY_THOUSAND = 50_000;
    final static int TEN_THOUSAND = 10_000;
    final static int FIVE_THOUSAND = 5_000;
    final static int ONE_THOUSAND = 1_000;
    final static int FIVE_HUNDRED = 500;
    final static int ONE_HUNDRED = 100;
    final static int FIFTY = 50;
    final static int TEN = 10;
    final static int ONE = 1;

    public static int getCapableBillCount(int bill, int money) {
        return money / bill;
    }

    public static List<Integer> getCapableBillsCount(List<Integer> bills, int money) {
        ArrayList<Integer> counts = new ArrayList<>();

        for (int bill: bills) {
            int count = getCapableBillCount(bill, money);
            money -= count * bill;

            counts.add(count);
        }

        return counts;
    }

    public static List<Integer> solution(int money) {
        return getCapableBillsCount(
                List.of(FIFTY_THOUSAND, TEN_THOUSAND, FIVE_THOUSAND, ONE_THOUSAND, FIVE_HUNDRED, ONE_HUNDRED, FIFTY, TEN, ONE),
                money);
    }
}
