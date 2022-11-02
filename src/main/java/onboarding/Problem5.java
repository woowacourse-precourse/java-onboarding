package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] units = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = getWalletResult(money);

        return answer;
    }

    private static List<Integer> getWalletResult(int money) {
        List<Integer> wallet = new ArrayList<>();
        int remain = money;

        for (int unit: units){
            int amount = getQuotientByUnit(remain, unit);
            remain = getRemainderByUnit(remain, unit);
            wallet.add(amount);
        }

        return wallet;
    }

    private static int getQuotientByUnit(int money, int unit) {
        return money / unit;
    }

    private static int getRemainderByUnit(int money, int unit) {
        return money % unit;
    }
}
