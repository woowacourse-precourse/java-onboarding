package onboarding;

import java.util.Set;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += checkThreeSixNinesCnt(i);
        }
        return answer;
    }

    private static int checkThreeSixNinesCnt(int checkNum) {
        Set<Integer> target = Set.of(3, 6, 9);
        int result = 0;

        while (checkNum != 0) {
            int num = checkNum % 10;
            if (target.contains(num)) {
                result++;
            }
            checkNum /= 10;
        }
        return result;
    }
}