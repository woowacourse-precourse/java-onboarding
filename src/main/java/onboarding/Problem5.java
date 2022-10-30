package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getExchangeCountList(money);
        return answer;
    }

    private static List<Integer> getExchangeCountList(int money){
        List<Integer> exchanges = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> exchangeCountList = new ArrayList<>();

        for (Integer exchange : exchanges) {
            int count = money / exchange;

            exchangeCountList.add(count);
            money -= exchange * count;
        }

        return exchangeCountList;
    }
}
