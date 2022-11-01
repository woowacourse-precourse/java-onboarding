package onboarding;

import java.util.List;

class Problem1 {
    public static final int MINIMUM_PAGE_NUMBER = 1;
    public static final int MAXIMUM_PAGE_NUMBER = 400;

    private static boolean existsPageNumber(Integer pageNumber) {
        if (MINIMUM_PAGE_NUMBER <= pageNumber && pageNumber <= MAXIMUM_PAGE_NUMBER) {
            return true;
        }
        return false;
    }

    private static boolean isOdd(Integer number) {
        if ((number % 2) == 1) {
            return true;
        }
        return false;
    }

    private static boolean isEven(Integer number) {
        if ((number % 2) == 0) {
            return true;
        }
        return false;
    }

    private static boolean isValidPageList(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        if (!existsPageNumber(leftPage) || !existsPageNumber(rightPage)) {
            return false;
        }
        if (!isOdd(leftPage) || !isEven(rightPage)) {
            return false;
        }
        if ((leftPage + 1) != rightPage) {
            return false;
        }
        return true;
    }

    private static int getMaximumPageValue(Integer pageNumber) {
        int sum = 0;
        int product = 1;

        while (pageNumber != 0) {
            int remainder = pageNumber % 10;
            pageNumber /= 10;
            sum += remainder;
            product *= remainder;
        }
        return Math.max(sum, product);
    }

    private static int getMaximumValueOfPageList(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        int maximumValueOfLeftPage = getMaximumPageValue(leftPage);
        int maximumValueOfRightPage = getMaximumPageValue(rightPage);
        return Math.max(maximumValueOfLeftPage, maximumValueOfRightPage);
    }

    private static int compareValues(int value1, int value2) {
        if (value1 > value2) {
            return 1;
        } else if (value1 < value2) {
            return 2;
        }
        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidPageList(pobi) || !isValidPageList(crong))
            return -1;

        int maximumValueOfPobi = getMaximumValueOfPageList(pobi);
        int maximumValueOfCrong = getMaximumValueOfPageList(crong);
        return compareValues(maximumValueOfPobi, maximumValueOfCrong);
    }
}