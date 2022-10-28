package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isOpenPageBoundOut(pobi) || isOpenPageBoundOut(crong)) {
            return Result.EXCEPTION.number;
        }

        if (!(isOpenPageCorrect(pobi) && isOpenPageCorrect(pobi))) {
            return Result.EXCEPTION.number;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        return getResult(pobiScore, crongScore);
    }

    private static int getResult(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return Result.POBI.number;
        }

        if (pobiScore < crongScore) {
            return Result.CRONG.number;
        }

        return Result.DRAW.number;
    }

    private static int getScore(List<Integer> pages) {
        int maxLeftPageNumber = getMaxPageNumber(pages.get(PageDirection.LEFT.index));
        int maxRightPageNumber = getMaxPageNumber(pages.get(PageDirection.RIGHT.index));
        return Math.max(maxLeftPageNumber, maxRightPageNumber);
    }

    private static int getMaxPageNumber(int pageNumber) {
        int sumPageNumber = getSumPageNumber(pageNumber);
        int productPageNumber = getProductPageNumber(pageNumber);
        return Math.max(sumPageNumber, productPageNumber);
    }

    private static int getProductPageNumber(int pageNumber) {
        int productPageNumber = 1;
        while (pageNumber > 0) {
            productPageNumber *= pageNumber % 10;
            pageNumber /= 10;
        }
        return productPageNumber;
    }

    private static int getSumPageNumber(int pageNumber) {
        int sumPageNumber = 0;
        while (pageNumber > 0) {
            sumPageNumber += pageNumber % 10;
            pageNumber /= 10;
        }
        return sumPageNumber;
    }

    private static boolean isOpenPageCorrect(List<Integer> openPages) {
        int leftPage = openPages.get(PageDirection.LEFT.index);
        int rightPage = openPages.get(PageDirection.RIGHT.index);
        return (rightPage - leftPage) == 1;
    }

    private static boolean isOpenPageBoundOut(List<Integer> openPages) {
        if (openPages.get(PageDirection.LEFT.index) < 1) {
            return true;
        }

        if (openPages.get(PageDirection.RIGHT.index) > 400) {
            return true;
        }

        return false;
    }

    private enum PageDirection {
        LEFT(0),
        RIGHT(1);

        private final int index;

        PageDirection(int index) {
            this.index = index;
        }
    }

    private enum Result {
        POBI(1),
        CRONG(2),
        DRAW(0),
        EXCEPTION(-1);

        private final int number;

        Result(int number) {
            this.number = number;
        }
    }
}
