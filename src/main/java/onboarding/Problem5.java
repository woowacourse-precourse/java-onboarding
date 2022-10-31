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

        for (int i = 0; i < moneySizeList.size(); i++) {
            int count = getMoneyCount(money, moneySizeList.get(i));
            answer.add(count);
            money -= moneySizeList.get(i)*count;
        }
        return answer;
    }

    private static int getMoneyCount(int money, int size) {
        return money / size;
    }
}
