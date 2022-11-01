package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> bill = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        for (int i = 0; i < bill.size(); i++) {
            int count = money / bill.get(i);
            answer.add(count);
            money -= count * bill.get(i);
        }

        return answer;
    }
}