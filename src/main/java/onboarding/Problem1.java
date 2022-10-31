package onboarding;

import java.util.List;

class Problem1 {

    static final int LEFT = 0;
    static final int RIGHT = 1;

    static final int POBI_WIN = 1;
    static final int CRONG_WIN = 2;
    static final int DRAW = 0;
    static final int EXCEPTION = -1;

    static final int BOOK_START_PAGE = 1;
    static final int BOOK_END_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isWrongInput(pobi) || isWrongInput(crong)) {
            return EXCEPTION;
        }

        String pobiLeftPage = Integer.toString(pobi.get(LEFT));
        String pobiRightPage = Integer.toString(pobi.get(RIGHT));
        String crongLeftPage = Integer.toString(crong.get(LEFT));
        String crongRightPage = Integer.toString(crong.get(RIGHT));

        int pobiMaxScore = Math.max(getMaxScore(pobiLeftPage), getMaxScore(pobiRightPage));
        int crongMaxScore = Math.max(getMaxScore(crongLeftPage), getMaxScore(crongRightPage));

        return getCompareResult(pobiMaxScore, crongMaxScore);
    }

    private static int getMaxScore(String pageNumber) {
        int sum = 0;
        int mul = 1;

        for (int i = 0; i < pageNumber.length(); i++) {
            sum += Character.getNumericValue(pageNumber.charAt(i));
            mul *= Character.getNumericValue(pageNumber.charAt(i));
        }

        return Math.max(sum, mul);
    }

    private static int getCompareResult(int pobiScore, int crongScore) {
        int ans = EXCEPTION;

        if (pobiScore > crongScore) {
            ans = POBI_WIN;
        } else if (pobiScore < crongScore) {
            ans = CRONG_WIN;
        } else if (pobiScore == crongScore) {
            ans = DRAW;
        }

        return ans;
    }

    // 개선 가능 (with strategy pattern)
    private static boolean isWrongInput(List<Integer> inputs) {
        int left = inputs.get(LEFT);
        int right = inputs.get(RIGHT);

        if (isNotSorted(left, right)) {
            return true;
        }
        if (getDifference(left, right) > 1) {
            return true;
        }
        if (isOutOfBound(left, right)) {
            return true;
        }

        return false;
    }

    private static boolean isOutOfBound(Integer left, Integer right) {
        return left <= BOOK_START_PAGE || right >= BOOK_END_PAGE;
    }

    private static boolean isNotSorted(Integer left, Integer right) {
        return left >= right;
    }

    private static int getDifference(Integer left, Integer right) {
        return Math.abs(left - right);
    }
}