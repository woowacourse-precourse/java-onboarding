package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i++) {
            String currentNumber = String.valueOf(i);
            answer += getClapCount(currentNumber);
        }
        return answer;
    }

    private static int getClapCount(String currentNumber) {
        return (int) IntStream.range(0, currentNumber.length())
                .filter(index -> containThreeSixNine(currentNumber, index))
                .count();
    }

    private static boolean containThreeSixNine(String currentNumber, int index) {
        return currentNumber.charAt(index) == '3' || currentNumber.charAt(index) == '6' || currentNumber.charAt(index) == '9';
    }
}
