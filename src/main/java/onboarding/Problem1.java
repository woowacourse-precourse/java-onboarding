package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int[] getArrayByNumber(int number) {
        // 숫자를 배열로 만드는 메소드
        String string = Integer.toString(number);
        int[] digits = new int[string.length()];

        for (int i = 0; i < string.length(); i++) {
            digits[i] = string.charAt(i) - '0';
        }

        Arrays.sort(digits);
        return digits;
    }

    private static int getSumByArray(int[] array) {
        // 배열의 각 자리수를 모두 더하는 메소드
        int sumValue = 0;
        for (int value : array) {
            sumValue += value;
        }

        return sumValue;
    }

}