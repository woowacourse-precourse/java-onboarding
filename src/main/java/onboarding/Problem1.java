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
        return pobi.get(1) - pobi.get(0) == 1 && crong.get(1) - crong.get(0) == 1;
    }

    private static boolean isRightEvenOddPage(List<Integer> pobi, List<Integer> crong) {
        return (pobi.get(0) % 2 == 1 && crong.get(0) % 2 == 1)
                && (pobi.get(1) % 2 == 0 && crong.get(1) % 2 == 0);
    }

    private static boolean isNotFirstOrLastPage(List<Integer> pobi, List<Integer> crong) {
        return (pobi.get(0) != 1 && pobi.get(1) != 400) && (crong.get(0) != 1 && crong.get(1) != 400);
    }

    private static int calculateMaxValue(List<Integer> list) {
        int maxValue = 0;

        for (Integer integer : list) {
            int maxValueOfPlus = 0;
            int maxValueOfMultiply = 1;

            while(integer > 0){
                maxValueOfPlus += integer % 10;
                maxValueOfMultiply *= integer % 10;
                integer /= 10;
            }
            maxValue = Math.max(maxValue, Math.max(maxValueOfPlus, maxValueOfMultiply));
        }

        return maxValue;
    }

    private static int calculateResult(int maxValueOfPobi, int maxValueOfCrong) {
        if (maxValueOfPobi > maxValueOfCrong) {
            return 1;
        } else if (maxValueOfPobi < maxValueOfCrong) {
            return 2;
        }
        return 0;
    }
}