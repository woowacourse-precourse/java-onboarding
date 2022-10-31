package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {

    final static List<Integer> billList = new ArrayList<>(
        Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int bill: billList) {
            int count = money / bill;
            answer.add(count);
            money = money % bill;
        }

        return answer;
    }
}
