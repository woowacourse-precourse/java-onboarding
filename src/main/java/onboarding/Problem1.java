package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validateInput(pobi) || !validateInput(crong)) {
            return -1;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore > crongScore) {
            return 1;
        }
        return pobiScore < crongScore ? 2 : 0;
    }

    private static boolean validateInput(List<Integer> pages) {
        if (pages.get(LEFT_PAGE) == pages.get(RIGHT_PAGE)-1) {
            return true;
        }
        return false;
    }

    private static int getScore(List<Integer> pages) {
        int addedLeft = addEachDigit(pages.get(LEFT_PAGE));
        int multipliedLeft = multiplyEachDigit(pages.get(LEFT_PAGE));
        int addedRight = addEachDigit(pages.get(RIGHT_PAGE));
        int multipliedRight = multiplyEachDigit(pages.get(RIGHT_PAGE));

        int leftScore = getBiggerNumber(addedLeft, multipliedLeft);
        int rightScore = getBiggerNumber(addedRight, multipliedRight);

        return getBiggerNumber(leftScore, rightScore);
    }

    private static int addEachDigit(int pageNum) {
        int sum = 0;
        while (pageNum != 0) {
            sum += pageNum % 10;
            pageNum /= 10;
        }
        return sum;
    }

    private static int multiplyEachDigit(int pageNum) {
        int product = 1;
        while (pageNum != 0) {
            product *= pageNum % 10;
            pageNum /= 10;
        }
        return product;
    }

    private static int getBiggerNumber(int numX, int numY) {
        if (numX > numY) {
            return numX;
        }
        return numY;
    }
}