package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] m = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        Integer[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int i = 0;
        while (money > 0 && i < 9) {
            while (money >= m[i]) {
                money -= m[i];
                arr[i]++;
            }
            i++;
        }
        answer = List.of(arr);
        return answer;
    }
}
