package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int play369(int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> digits = findDigits(i);

        }
        return count;
    }

    public static List<Integer> findDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n != 0) {
            int remainder = n % 10;
            n = n / 10;
            digits.add(remainder);
            findDigits(n);
        }
        return digits;
    }
}
