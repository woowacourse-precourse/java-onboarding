package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final List<Integer> moneySizeList = List.of(
            50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
    );

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (Integer integer : moneySizeList) {
            int count = getMoneyCount(money, integer);
            answer.add(count);
            money -= integer * count;
        }
        return answer;
    }

    private static int getMoneyCount(int money, int size) {
        return money / size;
    }
}
