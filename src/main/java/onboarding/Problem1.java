package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (exceptionCase(pobi) || exceptionCase(crong)) {
            return -1;
        }

        return compareNum(maxSum(pobi), maxSum(crong));
    }
}
