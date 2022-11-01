package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static final List<Integer> game369 = new ArrayList<>(Arrays.asList(3, 6, 9));

    public static Integer doClap(int number) {
        int clap = 0;

        while (number != 0) {
            if (game369.contains(number % 10)) {
                clap++;
            }
            number /= 10;
        }
        return clap;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += doClap(i);
        }
        return answer;
    }
}
