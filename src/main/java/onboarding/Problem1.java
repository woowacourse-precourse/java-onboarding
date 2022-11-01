package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validateInput(pobi) || !validateInput(crong)) {
            return -1;
        }
        return 0;
    }

    private static boolean validateInput(List<Integer> pages) {
        if (pages.get(LEFT_PAGE) == pages.get(RIGHT_PAGE)-1) {
            return true;
        }
        return false;
    }

    private static int getScore(List<Integer> pages) {
        return 0;
    }

    private static int addEachDigit(int pageNum) {
        return 0;
    }

    private static int multiplyEachDigit(int pageNum) {
        return 0;
    }

    private static int getBiggerNumber(int numX, int numY) {
    }
}