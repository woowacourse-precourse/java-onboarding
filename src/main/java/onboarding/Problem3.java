package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;

    }

    private static int[] splitEachNumbers(int number) {
        int[] arrNum = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return arrNum;
    }

    private static void countTargetNumber(int[] arrNum) {
        for (int i = 0; i<arrNum.length; i++) {
            if (i == 3 || i == 6 || i == 9) {
                clapCount = clapCount + 1;
            }
        }

    }
}
