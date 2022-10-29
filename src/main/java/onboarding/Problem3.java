package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            for (int num: toDigitList(i)) {
                System.out.println(num);
            }
        }

        return answer;
    }

    private static List<Integer> toDigitList(Integer number) {
        List<Integer> result = new ArrayList<>();

        while (number != 0) {
            result.add(number % 10);
            number /= 10;
        }

        return result;
    }
}
