package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static List<Integer> divideNumberByDigit (int number) {
        List<Integer> result = new ArrayList();
        for (int i = number; i > 0; i /= 10) {
            result.add(i % 10);
        }
        return result;
    }
}
