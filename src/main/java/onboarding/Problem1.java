package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isSatisfied(pobi) = 1 && isSatisfied(crong) = 1) {
            int answer = Integer.MAX_VALUE;
            return answer;
        }
        return -1;
    }

    public static boolean isSatisfied(List<Integer> array) {
        return array.get(0) > 1 && array.get(0) < 399 && array.get(1) - array.get(0) == 1;
    }

}