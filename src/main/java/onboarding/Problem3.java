package onboarding;

import java.util.Arrays;
import java.util.List;

import static onboarding.Problem3.Problem3Validation.validate;
import static onboarding.Util.convertIntegerToList;

public class Problem3 {
    private static final List<Integer> THREE_SIX_NINE_LIST = Arrays.asList(3, 6, 9);

    public static int solution(int number) {
        if (!validateInput(number)) {
            return number;
        }
        return calculateAnswer(number);
    }

    private static boolean validateInput(int number) {
        return validate(number);
    }

    private static int calculateAnswer(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += calculateTheNumberOf369(i);
        }
        return answer;
    }

    private static int calculateTheNumberOf369(int number) {
        int count = 0;

        for (Integer integer : convertIntegerToList(number)) {
            if (THREE_SIX_NINE_LIST.contains(integer)) {
                count++;
            }
        }
        return count;
    }

    static abstract class Problem3Validation extends Validation {
        private static final int MIN_VALUE = 1;
        private static final int MAX_VALUE = 10000;

        public static boolean validate(int number) {
            return validateIntegerRange(number, MIN_VALUE, MAX_VALUE);
        }
    }
}
