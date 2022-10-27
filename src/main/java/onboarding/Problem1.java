package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int[] getEachDigits(int page) {
        return Arrays.stream(String.valueOf(page).split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    public static int addEachDigits(int[] digits) {
        return Arrays.stream(digits).sum();
    }

    public static int multiplyEachDigits(int[] digits) {
        return Arrays.stream(digits)
            .reduce(1, Math::multiplyExact);
    }
}