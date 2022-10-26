package onboarding;

import java.util.List;

class Problem1 {
    static final int LEFT = 0;
    static final int RIGHT = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidate(pobi, crong)) {
            return -1;
        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     * 들어온 값에 대해 예외처리 하는 함수들 (책을 임의로 펼친다)
     */
    public static boolean isValidate(List<Integer> pobi, List<Integer> crong) {
        return (validatePages(pobi) && validatePages(crong));
    }

    private static boolean validatePages(List<Integer> pages) {
        return (validateSize(pages) &&
                validateContinuity(pages) &&
                validateRangeOfPages(pages) &&
                validateOddEven(pages)
        );
    }

    private static boolean validateSize(List<Integer> pages) {
        return (pages.size() == 2);
    }

    private static boolean validateContinuity(List<Integer> pages) {
        return pages.get(LEFT) + 1 == pages.get(RIGHT);
    }

    private static boolean validateRangeOfPages(List<Integer> pages) {
        Integer left = pages.get(LEFT);
        Integer right = pages.get(RIGHT);
        return (validateRangeOfPage(left) && validateRangeOfPage(right));
    }

    private static boolean validateRangeOfPage(Integer page) {
        return (page > 0 && page < 401);
    }

    private static boolean validateOddEven(List<Integer> pages) {
        Integer left = pages.get(LEFT);
        Integer right = pages.get(RIGHT);
        return (isLeftPageOdd(left) && isRightPageEven(right));
    }

    private static boolean isLeftPageOdd(Integer left) {
        return (left % 2 == 1);
    }

    private static boolean isRightPageEven(Integer right) {
        return (right % 2 == 0);
    }

    /**
     * 각 자리의 숫자를 모두 더하거나 곱하여 가장 큰 수를 구한다.
     */

    private static int getSumOfEachDigit(Integer page, int result) {
        if (page < 10) {
            return result + page;
        }
        return getSumOfEachDigit(page / 10, result + page % 10);
    }

    private static int getMultipleOfEachDigit(Integer page, int result) {
        if (page < 10) {
            return result * page;
        }
        return getMultipleOfEachDigit(page / 10, result * (page % 10));
    }
}