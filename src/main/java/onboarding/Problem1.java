package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean validateCondition(List<Integer> pobi, List<Integer> crong) {
        return isRightLength(pobi, crong)
                && isRightPage(pobi, crong)
                && isRightEvenOddPage(pobi, crong)
                && isNotFirstOrLastPage(pobi, crong);
    }

    private static boolean isRightLength(List<Integer> pobi, List<Integer> crong) {
        return pobi.size() == 2 && crong.size() == 2;
    }

    private static boolean isRightPage(List<Integer> pobi, List<Integer> crong) {
        return false;
    }

    private static boolean isRightEvenOddPage(List<Integer> pobi, List<Integer> crong) {
        return false;
    }

    private static boolean isNotFirstOrLastPage(List<Integer> pobi, List<Integer> crong) {
        return false;
    }

    private static int calculateMaxValue(List<Integer> list) {
        return 0;
    }

    private static int calculateResult(int maxValueOfPobi, int maxValueOfCrong) {
        return 0;
    }
}