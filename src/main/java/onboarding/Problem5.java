package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = convertMoneyToBill(money);

        return answer;
    }

    private static List<Integer> convertMoneyToBill(int money) {
        List<Integer> billList = new ArrayList<>();

        int[] bills = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < bills.length; i++) {
            billList.add(money / bills[i]);
            money %= bills[i];
        }

        return billList;
    }
}
