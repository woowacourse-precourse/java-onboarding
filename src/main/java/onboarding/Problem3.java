package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        return countTotalClaps(number);
    }

    private static int countTotalClaps(int number) {
        int totalCount = 0;

        for (int i = 1; i <= number; i++) {
            totalCount += countClap(i);
        }

        return totalCount;
    }

    private static int countClap(int number) {
        List<Integer> criteria = List.of(3, 6, 9);
        int count = 0;

        while (number > 0) {
            if (criteria.contains(number % 10)) count++;
            number /= 10;
        }

        return count;
    }
}
