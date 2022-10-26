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

    private static boolean validateBetweenLeftAndRightPage(Integer leftPageNumber,
        Integer rightPageNumber) {
        if (rightPageNumber - leftPageNumber != 1) {
            return false;
        }
        return true;
    }

    private static boolean validateRightPage(Integer rightPageNumber) {
        if (rightPageNumber % 2 != 0) {
            return false;
        }
        return true;
    }
}