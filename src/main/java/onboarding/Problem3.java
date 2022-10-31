package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        while (num > 0) {
            digits.add(num % 10);
            num = num / 10;
        }
        return digits;
    }
}
