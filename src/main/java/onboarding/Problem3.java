package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        validateNumberRange(number);

        int answer = 0;

        Integer[] memo = new Integer[number + 1];
        memo[0] = 0;

        getClapCount(number, memo);

        answer = memo[number];
        return answer;
    }

    private static void getClapCount(int number, Integer[] memo) {
        List<Integer> clapList = Arrays.asList(3, 6, 9);

        for (int i = 1; i <= number; i++) {
            int clapCnt = 0;
            String[] splitNums = String.valueOf(i).split("");

            for (String num : splitNums) {
                if (clapList.contains(Integer.parseInt(num))) {
                    clapCnt++;
                }
            }

            memo[i] = memo[i - 1] + clapCnt;
        }
    }

    private static void validateNumberRange(int number) {
        if (number < 1 || number > 10000) {
            throw new IllegalArgumentException("number는 1이상 10000이하여야 합니다.");
        }
    }
}
