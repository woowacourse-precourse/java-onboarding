package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> bills = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int count;

        for(Integer bill : bills) {
            count = getCount(money, bill);
            answer.add(count);
            money -= bill * count;
        }

        return answer;
    }

    private static int getCount(int money, int bill) {
        return money / bill;
    }
}
