package onboarding;

import java.util.List;

class Problem1 {
    public static final int LEFT_PAGE = 0;
    public static final int RIGHT_PAGE = 1;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMaxScore = getMaxScore(pobi);
        int crongMaxScore = getMaxScore(crong);

        return getAnswer(pobiMaxScore, crongMaxScore);
    }
    private static int getAnswer(int pobiMaxScore, int crongMaxScore) {
        if (pobiMaxScore > crongMaxScore) {
            return POBI_WIN;
        } else if (pobiMaxScore < crongMaxScore) {
            return CRONG_WIN;
        } else {
            return DRAW;
        }
    }
    public static int getMaxScore(List<Integer> pages) {
        int leftPageNumber = getLeftPageNumber(pages);
        int leftPageNumberMax = findMaxOfMultiAndAdd(leftPageNumber);

        int rightPageNumber = getRightPageNumber(pages);
        int rightPageNumberMax = findMaxOfMultiAndAdd(rightPageNumber);

        return Math.max(leftPageNumberMax, rightPageNumberMax);
    }

    private static int getRightPageNumber(List<Integer> pages) {
        return pages.get(RIGHT_PAGE);
    }

    private static int getLeftPageNumber(List<Integer> pages) {
        return pages.get(LEFT_PAGE);
    }
    private static int findMaxOfMultiAndAdd(int pageNum) {
        int sum = addElements(pageNum);
        int multi = multiElements(pageNum);
        return Math.max(sum, multi);
    }
    public static int addElements(int n) {
        int total = 0;

        while (n > 0) {
            total += n % 10;
            n = n / 10;
        }

        return total;
    }
    public static int multiElements(int n) {
        int total = 1;

        while (n > 0) {
            total *= n % 10;
            n = n / 10;
        }

        return total;
    }
}
