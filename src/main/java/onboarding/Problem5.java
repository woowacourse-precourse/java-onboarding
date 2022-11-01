package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            answer.add(0);
        }
        int temp = 0, count = 7;
        answer.set(8, money % 10);
        money /= 10;
        while (money != 0) {
            temp = money % 10;
            if (temp % 5 == 0) answer.set(count - 1, temp / 5);
            else answer.set(count, temp);
            money /= 10;
            count -= 2;
        }
        return answer;
    }
}
