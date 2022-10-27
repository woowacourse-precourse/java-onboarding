package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static final List<Integer> game369 = new ArrayList<>(Arrays.asList(3, 6, 9));

    public static Integer countClap(int number) {
        int count = 0;

        while (number != 0) {
            if (game369.contains(number % 10)) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }
}
