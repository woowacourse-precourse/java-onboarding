package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static List<Integer> getIntegersUnderNumber(int number) {
        List<Integer> integersUnderNumber = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            integersUnderNumber.add(i);
        }
        return integersUnderNumber;
    }

    private static char[] getCharsOfNumber(int number) {
        String numberToString = String.valueOf(number);
        char[] charsOfNumber = numberToString.toCharArray();
        return charsOfNumber;
    }
}
