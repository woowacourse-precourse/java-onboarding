package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static void getClapCount(int number) {
        List<Integer> clapList = Arrays.asList(3, 6, 9);

        for (int i = 1; i <= number; i++) {
            int clapCnt = 0;
            String[] splitNums = String.valueOf(i).split("");

            for (String num : splitNums) {
                if (clapList.contains(Integer.parseInt(num))) {
                    clapCnt++;
                }
            }
        }
    }
}
