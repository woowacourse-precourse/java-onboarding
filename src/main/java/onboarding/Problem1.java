package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean validatePageRange(Integer pageNumber) {
        if (!(3 <= pageNumber && pageNumber <= 398)) {
            return false;
        }
        return true;
    }
}