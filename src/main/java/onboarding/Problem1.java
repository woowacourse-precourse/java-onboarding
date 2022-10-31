package onboarding;

import java.util.List;

/**
 * isCorrectPages 메서드 입력받은 페이지값이 올바른지 확인
 * getSumOfPages 메서드 페이지의 각자리수의 합을 반환
 * getMultiplyOfPages 메서드 페이지의 각자리수의 곱을 반환
 * getMaxOfPages 메서드 페이지의 각자리수 합과 곱 중 더 큰값을 반환
 * compareOfResult 메서드 값을 비교하여 승자를 반환
 */

class Problem1 {
    private static final int DRAW = 0;
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    private static final int WIN_POBI = 1;
    private static final int WIN_CRONG = 2;
    private static final int EXCEPTION = -1;

    private static int maxScoreOfPobi;
    private static int maxScoreOfCrong;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isCorrectPages(pobi) || isCorrectPages(crong)) return EXCEPTION;
        maxScoreOfPobi = getMaxOfPages(pobi);
        maxScoreOfCrong = getMaxOfPages(crong);
        return compareOfResult(maxScoreOfPobi, maxScoreOfCrong);
    }

    private static boolean isCorrectPages(List<Integer> pages) {
        if (pages.get(RIGHT_PAGE) - pages.get(LEFT_PAGE) != 1) return true;
        if (pages.get(LEFT_PAGE) < 1 || pages.get(RIGHT_PAGE) > 400) return true;
        if (pages.size() != 2) return true;
        if (pages.get(LEFT_PAGE) % 2 != 1 || pages.get(RIGHT_PAGE) % 2 != 0) return true;
        return false;
    }


    private static int compareOfResult(int maxOfPobi, int maxOfCrong) {
        if (maxOfPobi == maxOfCrong) return DRAW;
        return maxOfPobi > maxOfCrong ? WIN_POBI : WIN_CRONG;
    }

    private static int getMaxOfPages(List<Integer> pages) {
        int maxOfSumResult, maxOfMultiplyResult;
        String leftPageTypeOfString = String.valueOf(pages.get(LEFT_PAGE));
        String rightPageTypeOfString = String.valueOf(pages.get(RIGHT_PAGE));

        maxOfSumResult = Math.max(getSumOfPages(leftPageTypeOfString), getSumOfPages(rightPageTypeOfString));
        maxOfMultiplyResult = Math.max(getMultiplyOfPages(leftPageTypeOfString),
                getMultiplyOfPages(rightPageTypeOfString));

        return Math.max(maxOfSumResult, maxOfMultiplyResult);
    }

    private static int getSumOfPages(String pages) {
        int sumOfPages = 0;
        for (int i = 0; i < pages.length(); i++) {
            sumOfPages += (pages.charAt(i) - '0');
        }
        return sumOfPages;
    }

    private static int getMultiplyOfPages(String pages) {
        int multiplyOfPages = 1;
        for (int i = 0; i < pages.length(); i++) {
            multiplyOfPages *= (pages.charAt(i) - '0');
        }
        return multiplyOfPages;
    }
}
