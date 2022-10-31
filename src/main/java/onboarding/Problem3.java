package onboarding;

import java.util.List;

public class Problem3 {
    private static final List<Integer> TARGET_NUMBERS = List.of(3, 6, 9);

    public static int solution(int number) {
        return countClaps(number);
    }

    private static int countClaps(int number) {
        int count = 0;
        int n;

        for (int index = 1; index <= number; index++) {
            n = index;
            while (n > 0) {
                if (TARGET_NUMBERS.contains(n % 10)) {
                    count++;
                }
                n /= 10;
            }
        }

        return count;
    }
}
