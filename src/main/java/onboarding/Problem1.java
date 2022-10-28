package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidate(pobi, crong)) {
            return -1;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        return getWinner(pobiScore, crongScore);
    }

    /**
     * 들어온 값에 대해 예외처리 하는 함수들 (책을 임의로 펼친다)
     */
    private static boolean isValidate(List<Integer> pobi, List<Integer> crong) {
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

    /**
     * 본인의 점수를 구하는 기능
     */
    private static int getScore(List<Integer> pages) {
        int leftScore = getScoreOfEachPage(pages.get(LEFT));
        int rightScore = getScoreOfEachPage(pages.get(RIGHT));

        return Math.max(leftScore, rightScore);
    }
    private static int getScoreOfEachPage(Integer page) {
        int sumOfEachDigit = getSumOfEachDigit(page, 0);
        int multipleOfEachDigit = getMultipleOfEachDigit(page, 1);

        return Math.max(sumOfEachDigit, multipleOfEachDigit);
    }

    /**
     * 승자를 구하는 기능을 추가
     */
    private static int getWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }
        if (crongScore > pobiScore) {
            return 2;
        }
        return 0;
    }
}