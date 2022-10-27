package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Problem3 {

    private static final List<Integer> THREE_SIX_NINE_LIST = Arrays.asList(3, 6, 9);

    public static int solution(int number) {
        if (!validateInput(number)) {
            return number;
        }
        return calculateAnswer(number);
    }

    private static boolean validateInput(int number) {
        return Validation.validate(number);
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

        for (Integer integer : convertIntToIntegerList(number)) {
            if (THREE_SIX_NINE_LIST.contains(integer)) {
                count++;
            }
        }
        return count;
    }

    private static List<Integer> convertIntToIntegerList(int number) {
        Stream<Integer> stream = Stream
                .of(String.valueOf(number)
                .split(""))
                .mapToInt(Integer::parseInt)
                .boxed();
        return Arrays.asList(stream.toArray(Integer[]::new));
    }

    static abstract class Validation {
        private static final int MIN_VALUE = 1;
        private static final int MAX_VALUE = 10000;

        public static boolean validate(int number) {
            return validateRange(number);
        }

        private static boolean validateRange(int number) {
            return number >= MIN_VALUE
                    && number <= MAX_VALUE;
        }
    }
}
