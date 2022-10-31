package onboarding;

import java.util.List;

class Problem1 {

    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!(isValidation(pobi) && isValidation(crong))) {
            return -1;
        }

        int pobiValue = maxValueOfSumOrMultiply(pobi);
        int crongValue = maxValueOfSumOrMultiply(crong);

        return getWinner(pobiValue, crongValue);
    }

    private static boolean isValidation(List<Integer> pages) {
        int leftPage = getLeftPage(pages);
        int rightPage = getRightPage(pages);
        if (isOutOfRange(leftPage) || isOutOfRange(rightPage)) {
            return false;
        } else if (isNotOddNumber(leftPage)) {
            return false;
        } else if (isNotEvenNumber(rightPage)) {
            return false;
        }
        return checkPageOrder(leftPage, rightPage);
    }

    private static Integer getLeftPage(List<Integer> pages) {
        return pages.get(0);
    }

    private static Integer getRightPage(List<Integer> pages) {
        return pages.get(1);
    }

    private static boolean isOutOfRange(int pageNumber) {
        return pageNumber < MIN_PAGE || MAX_PAGE < pageNumber;
    }

    private static boolean isNotOddNumber(int pageNumber) {
        return pageNumber % 2 != 1;
    }

    private static boolean isNotEvenNumber(int pageNumber) {
        return pageNumber % 2 != 0;
    }

    private static boolean checkPageOrder(int leftPage, int rightPage) {
        return (rightPage - leftPage) == 1;
    }

    private static int maxValueOfSumOrMultiply(List<Integer> pages) {
        int leftPage = getLeftPage(pages);
        int rightPage = getRightPage(pages);
        int leftPageResult = Math.max(sumOfEachDigitNumber(leftPage), multiplyOfEachDigitNumber(leftPage));
        int rightPageResult = Math.max(sumOfEachDigitNumber(rightPage), multiplyOfEachDigitNumber(rightPage));
        return Math.max(leftPageResult, rightPageResult);
    }

    private static int sumOfEachDigitNumber(int number) {
        int result = 0;
        while (isNotZero(number)) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    private static int multiplyOfEachDigitNumber(int number) {
        int result = 1;
        while (isNotZero(number)) {
            result *= number % 10;
            number /= 10;
        }
        return result;
    }

    private static boolean isNotZero(int number) {
        return number != 0;
    }

    private static int getWinner(int pobi, int crong) {
        if (isPobiWinner(pobi, crong)) {
            return 1;
        } else if (isCrongWinner(pobi, crong)) {
            return 2;
        } else {
            return 0;
        }
    }

    private static boolean isPobiWinner(int pobi, int crong) {
        return pobi > crong;
    }

    private static boolean isCrongWinner(int pobi, int crong) {
        return pobi < crong;
    }
}