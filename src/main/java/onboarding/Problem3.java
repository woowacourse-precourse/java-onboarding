package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int finalClapCount = 0;
        for (int i = 1; i<=number; i++) {
            int[] arrNum = splitEachNumbers(i);
            int clapCount = countTargetNumber(arrNum);
            finalClapCount = finalClapCount + clapCount;
        }
        return finalClapCount;
    }

    private static int[] splitEachNumbers(int number) {
        int[] arrNum = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return arrNum;
    }

    private static int countTargetNumber(int[] arrNum) {
        int clapCount = 0;
        for (int i = 0; i<arrNum.length; i++) {
            if (arrNum[i] == 3 || arrNum[i] == 6 || arrNum[i] == 9) {
                clapCount = clapCount + 1;
            }
        }
        return clapCount;
    }
}
