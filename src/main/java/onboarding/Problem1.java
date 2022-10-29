package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (exceptional(pobi, crong)) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean exceptional(List<Integer> pobi, List<Integer> crong) {
        return !PageValidator.validate(pobi) || !PageValidator.validate(crong);
    }
}
