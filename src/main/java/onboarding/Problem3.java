package onboarding;

import java.util.Set;

public class Problem3 {
    static final Set<Integer> clabNumber = Set.of(3, 6, 9);

    public static int solution(int number) {
        int clabCount = 0;
        int n = 1;

        if (number < 1 || number > 10000) {
            return -1;
        }

        while (n <= number) {
            clabCount += clab(n);
            n++;
        }

        return clabCount;
    }

    private static int clab(int n) {
        int count = 0;

        while (n > 0) {
            if (clabNumber.contains(n % 10)) {
                count++;
            }
            n /= 10;
        }

        return count;
    }
}
