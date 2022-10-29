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
        int answer = Integer.MAX_VALUE;

        return answer;
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
        if (pobiMaxScore < crongMaxScore) {
            return CRONG_WIN;
        }
        if (pobiMaxScore > crongMaxScore) {
            return POBI_WIN;
        }
        return DRAW;
    }
}
