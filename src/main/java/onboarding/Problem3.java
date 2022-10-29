package onboarding;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {

    private static Set<Character> clapRule = new HashSet<>();
    private static final int START_NUMBER = 1;

    public static int solution(int number) {
        addClapRule();
        int allClapCount = 0;

        for (int i = START_NUMBER; i <= number; i++) {
            String intToStringNumber = String.valueOf(i);
            int numberOfDigits = intToStringNumber.length();

            for (int j = 0; j < numberOfDigits; j++) {
            }
        }

        int answer = 0;
        return answer;
    }

    private static void addClapRule() {
        clapRule.add('3');
        clapRule.add('6');
        clapRule.add('9');
    }
}
