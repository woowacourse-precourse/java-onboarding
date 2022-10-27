package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] monetaryUnit = new int[] {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

        if (money < 1 || money > 1_000_000) {
            return Collections.emptyList();
        }
        

        return answer;
    }
}
