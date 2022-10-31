package onboarding;

import java.util.List;

public class Problem3 {
    private static final List<Integer> CLAP_NUMBERS = List.of(3, 6, 9);

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += getClapCount(i);
        }

        return answer;
    }

    private static int getClapCount(int number) {
        int clapCount = 0;

        while (number > 0) {
            if (CLAP_NUMBERS.contains(number % 10)) {
                clapCount++;
            }
            number /= 10;
        }

        return clapCount;
    }
}
