package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {

    private static final int[] CASH = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    private static final int[] wallet = new int[CASH.length];

    public static List<Integer> solution(int money) {
        initWallet();

        convertToMoneyFrom(money);
    }

    private static void convertToMoneyFrom(int money) {
        int currentCashIndex = 0;
        while (checkNotEnoughMoney(money)) {
            boolean isCashBiggerThanMoney = checkCashIsBiggerThanLeftMoney(money, currentCashIndex);
            money = calculateLeftMoney(money, currentCashIndex, isCashBiggerThanMoney);
            currentCashIndex = getNextCashIndex(currentCashIndex, isCashBiggerThanMoney);
        }
    }

    private static boolean checkNotEnoughMoney(int money) {
        return money != 0;
    }

    private static boolean checkCashIsBiggerThanLeftMoney(int money, int currentMoneyIndex) {
        return money < CASH[currentMoneyIndex];
    }

    private static int calculateLeftMoney(int money, int currentCashIndex, boolean isCashBiggerThanMoney) {
        if (!isCashBiggerThanMoney) {
            money -= CASH[currentCashIndex];
            wallet[currentCashIndex]++;
        }
        return money;
    }

    private static int getNextCashIndex(int currentCashIndex, boolean isCashBiggerThanMoney) {
        if (isCashBiggerThanMoney) {
            currentCashIndex++;
        }
        return currentCashIndex;
    }

    private static void initWallet() {
        Arrays.fill(wallet, 0);
    }
}
