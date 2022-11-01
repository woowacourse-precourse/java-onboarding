package onboarding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List<Integer> target = Arrays.asList(new Integer[]{3, 6, 9});

        for(int i = 1; i <= number; i++) {
            int count = i;
            while (count != 0) {
                if (target.contains(count % 10)) {
                    answer += 1;
                }
                count /= 10;
            }
        }

        return answer;
    }
}
