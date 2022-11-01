package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += have369(i);
        }

        return answer;
    }
    private static int have369(int number) {
        int count = 0;

        while (number != 0) {
            int q = number % 10;
            if (q == 3 || q == 6 || q == 9) count++;
            number /= 10;
        }

        return count;
    }
}
