package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem5 {
    static class Exchange {
        static List<Integer> exchangeMoneyList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        public static List<Integer> moneyCount(int money) {
            int[] count = new int[exchangeMoneyList.size()];
            Arrays.fill(count, 0);

            for (int exchange : exchangeMoneyList) {
                count[exchangeMoneyList.indexOf(exchange)] = money / exchange;
                money %= exchange;
            }
            return IntStream.of(count).boxed().collect(Collectors.toList());
        }

    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Exchange.moneyCount(money);
        return answer;
    }
}