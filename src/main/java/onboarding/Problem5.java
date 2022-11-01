package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = count(money);
        return answer;
    }

    static ArrayList<Integer> count(int money) {
        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayList<Integer> type = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        int value;
        for (int i = 0; i < 9; i++) {
            value = money / type.get(i);
            resultList.add(value);
            money = money - type.get(i) * value;
        }
        return resultList;
    }
}
