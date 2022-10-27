package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            List<Integer> digits = getDigitList(i);
        }
        return answer;
    }

    private static List<Integer> getDigitList(int number) {
        List<Integer> digitList = new ArrayList<>();
        while (number != 0) {
            digitList.add(number % 10);
            number /= 10;
        }
        return digitList;
    }
}
