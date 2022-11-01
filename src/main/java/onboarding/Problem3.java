package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {

    private static List<String> parseDigits(int num) {
        List<String> digits = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            String s = Integer.toString(i);
            digits.addAll(Arrays.asList(s.split("")));
        }

        return digits;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
