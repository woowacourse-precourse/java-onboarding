package onboarding;

import java.util.List;

class Problem1 {
    public static final int EXCEPTION = -1;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;
    public static final int LEFT_PAGE_INDEX = 0;
    public static final int RIGHT_PAGE_INDEX = 1;
    public static final int MIN_PAGE = 1;
    public static final int MAX_PAGE = 400;
    public static final int INIT_ZERO = 0;
    public static final int INIT_ONE = 1;
    public static final int PAGE_INTERVAL = 1;
    public static final int DIVIDE_NUMBER = 10;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi) || isException(crong)) {
            return EXCEPTION;
        }

        int pobiMax = maxScore(pobi);
        int crongMax = maxScore(crong);
        int answer = makeWinner(pobiMax, crongMax);

        return answer;
    }

    public static boolean isException(List<Integer> pageList) {
        if (isPageIntervalException(pageList)) {
            return true;
        }

        if (isPagePositionException(pageList)) {
            return true;
        }

        for (Integer pageNumber : pageList) {
            if (isNotValidException(pageNumber)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotValidException(Integer pageNumber) {
        return (pageNumber > MAX_PAGE || pageNumber < MIN_PAGE);
    }

    private static boolean isPagePositionException(List<Integer> pageList) {
        return (pageList.get(RIGHT_PAGE_INDEX) < pageList.get(LEFT_PAGE_INDEX));
    }

    private static boolean isPageIntervalException(List<Integer> pageList) {
        return (pageList.get(RIGHT_PAGE_INDEX) - pageList.get(LEFT_PAGE_INDEX) > PAGE_INTERVAL);
    }

    public static int maxScore(List<Integer> pageList) {
        int max = INIT_ZERO;

        for (Integer pageNumber : pageList) {
            if (max < compareSum(pageNumber)) {
                max = compareSum(pageNumber);
            }
        }
        return max;
    }

    public static int compareSum(int pageNumber) {
        return (maxPlusSum(pageNumber) >= maxMultiplySum(pageNumber)) ? maxPlusSum(pageNumber) : maxMultiplySum(pageNumber);
    }

    private static int maxMultiplySum(int pageNumber) {
        int multiplySum = INIT_ONE;

        while (pageNumber != 0) {
            multiplySum *= pageNumber % DIVIDE_NUMBER;
            pageNumber /= DIVIDE_NUMBER;
        }
        return multiplySum;
    }

    private static int maxPlusSum(int pageNumber) {
        int plusSum = INIT_ZERO;

        while (pageNumber != 0) {
            plusSum += pageNumber % DIVIDE_NUMBER;
            pageNumber /= DIVIDE_NUMBER;
        }
        return plusSum;
    }

    public static int makeWinner(int pobiMax, int crongMax) {
        if (pobiMax < crongMax) {
            return CRONG_WIN;
        } else if (pobiMax > crongMax) {
            return POBI_WIN;
        }
        return DRAW;
    }
}