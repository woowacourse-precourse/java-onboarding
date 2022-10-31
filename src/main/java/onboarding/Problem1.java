package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        final int pobiLeftPage = pobi.get(LEFT_PAGE);
        final int pobiRightPage = pobi.get(RIGHT_PAGE);
        final int crongLeftPage = crong.get(LEFT_PAGE);
        final int crongRightPage = crong.get(RIGHT_PAGE);

        if (!handleException(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)) {
            return EXCEPTION;
        }

        int pobiMaxScore = Math.max(getMaxScore(pobiLeftPage), getMaxScore(pobiRightPage));
        int crongMaxScore = Math.max(getMaxScore(crongLeftPage), getMaxScore(crongRightPage));

        return getWinner(pobiMaxScore, crongMaxScore);
    }

    private static boolean handleException(int pobiLeftPage, int pobiRightPage, int crongLeftPage, int crongRightPage) {
        if (!oddEvenCheck(pobiLeftPage, pobiRightPage) || !oddEvenCheck(crongLeftPage, crongRightPage)) {
            return false;
        }
        if (isNotOneDifferencePage(pobiLeftPage, pobiRightPage) || isNotOneDifferencePage(crongLeftPage, crongRightPage)) {
            return false;
        }

        return !isStartOrEndPageNum(pobiLeftPage) && !isStartOrEndPageNum(pobiRightPage) && !isStartOrEndPageNum(crongLeftPage) && !isStartOrEndPageNum(crongRightPage);
    }

    private static boolean isStartOrEndPageNum(int pageNum) {
        return pageNum == 400 || pageNum == 1;
    }

    private static boolean isNotOneDifferencePage(int leftPage, int rightPage) {
        return (leftPage + 1) != rightPage;
    }

    private static boolean oddEvenCheck(int leftPage, int rightPage) {
        return isLeftOdd(leftPage) && isRightEven(rightPage);
    }

    private static boolean isLeftOdd(int leftPage) {
        return leftPage % 2 == 1;
    }

    private static boolean isRightEven(int rightPage) {
        return rightPage % 2 == 0;
    }

    private static int getMaxScore(int pageNumber) {
        List<Integer> splitNumber = splitDigitNumber(pageNumber);
        return Math.max(getPlusScore(splitNumber), getMultiplyScore(splitNumber));
    }

    private static int getPlusScore(List<Integer> splitNumber) {
        return splitNumber.stream().mapToInt(i -> i).sum();
    }

    private static int getMultiplyScore(List<Integer> splitNumber) {
        return splitNumber.stream().reduce(1, (a, b) -> a * b);
    }

    private static List<Integer> splitDigitNumber(int pageNumber) {
        List<Integer> splitNumber = new ArrayList<>();
        while (pageNumber > 0) {
            splitNumber.add(pageNumber % 10);
            pageNumber /= 10;
        }
        return splitNumber;
    }

    private static int getWinner(int pobiMaxScore, int crongMaxScore) {
        return (pobiMaxScore == crongMaxScore) ? DRAW : pobiMaxScore < crongMaxScore ? CRONG_WIN : POBI_WIN;
    }
}
