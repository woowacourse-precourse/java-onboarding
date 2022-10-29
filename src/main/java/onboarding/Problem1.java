package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int[] getSortedArrayByNumber(int number) {
        // 숫자를 정렬된 배열로 만드는 메소드
        String string = Integer.toString(number);
        int[] digits = new int[string.length()];

        for (int i = 0; i < string.length(); i++) {
            digits[i] = string.charAt(i) - '0';
        }

        Arrays.sort(digits);
        return digits;
    }
}