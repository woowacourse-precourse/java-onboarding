package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countByEachNum(i, Arrays.asList(3, 6, 9));
        }

        return answer;
    }

    private static int countByEachNum(Integer target, List<Integer> conditionList) {
        int result = 0;

        for (Integer num: toDigitList(target)) {
            if (checkCondition(num, conditionList)) {
                result++;
            }
        }

        return result;
    }

    private static boolean checkCondition(Integer number, List<Integer> conditionList) {
        return conditionList.contains(number);
    }

    private static List<Integer> toDigitList(Integer number) {
        List<Integer> result = new ArrayList<>();

        while (number != 0) {
            result.add(number % 10);
            number /= 10;
        }

        return result;
    }
}
