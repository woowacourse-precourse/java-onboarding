package onboarding;

import java.util.List;

class Problem1 {

    public static final int EXCEPTION = -1;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 1;
    public static final int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeftPageNumber = pobi.get(0);
        int pobiRightPageNumber = pobi.get(1);
        int crongLeftPageNumber = crong.get(0);
        int crongRightPageNumber = crong.get(1);

        if (isNotLengthTwo(pobi.size()) || isNotLengthTwo(crong.size())) {
            return EXCEPTION;
        }

        if (isNotLeftAndRight(pobiLeftPageNumber, pobiRightPageNumber) || isNotLeftAndRight(crongLeftPageNumber, crongRightPageNumber)) {
            return EXCEPTION;
        }

        if (isStartOrLastPage(pobiLeftPageNumber) || isStartOrLastPage(pobiRightPageNumber) || isStartOrLastPage(crongLeftPageNumber) || isStartOrLastPage(crongRightPageNumber)) {
            return EXCEPTION;
        }

        int pobiMaxNumber = Math.max(calculateMaxNumber(pobiLeftPageNumber), calculateMaxNumber(pobiRightPageNumber));
        int crongMaxNumber = Math.max(calculateMaxNumber(crongLeftPageNumber), calculateMaxNumber(crongRightPageNumber));

        answer = findWinner(pobiMaxNumber, crongMaxNumber);

        return answer;
    }

    private static boolean isNotLengthTwo(int length) {
        if (length != 2) {
            return true;
        }
        return false;
    }

    private static boolean isNotLeftAndRight(int leftPageNumber, int rightPageNumber) {
        return rightPageNumber - leftPageNumber != 1;
    }

    private static boolean isStartOrLastPage(int pageNumber) {
        return pageNumber == 1 || pageNumber == 400;
    }

    private static int calculateMaxNumber(int pageNumber) {
        int sum = 0;
        int multiply = 1;

        while (pageNumber > 0) {
            int eachDigit = pageNumber % 10;
            sum += eachDigit;
            multiply *= eachDigit;
            pageNumber /= 10;
        }

        return Math.max(sum, multiply);
    }

    private static int findWinner(int pobiMaxNumber, int crongMaxNumber) {
        if (pobiMaxNumber > crongMaxNumber) {
            return POBI_WIN;
        } else if (pobiMaxNumber < crongMaxNumber) {
            return CRONG_WIN;
        } else {
            return DRAW;
        }
    }
}