package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return divideMoneySequential(money);
    }

    public static List<Integer> divideMoneySequential(int money) {
        List<Integer> moneyList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> moneyCount = new ArrayList<>();

        for (Integer integer : moneyList) {
            int sum = 0;

            if (money >= integer) {
                sum = money / integer;
                money %= integer;
            }
            moneyCount.add(sum);
        }
        return moneyCount;
    }
}