package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            List<Integer> digits = int2array(i);
            for (Integer digit : digits) {
                if (digit == 3 || digit == 6 || digit == 9)
                    answer += 1;
            }
        }
        return answer;
    }
    private static List<Integer> int2array(int num) {
        List<Integer> digits = new ArrayList<>();

        while(num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }
}
