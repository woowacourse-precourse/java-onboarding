package onboarding;

import java.util.List;

class Problem11 {
    static final int LEFT = 0;
    static final int RIGHT = 1;

    static final int POBI_WIN = 1;
    static final int CRONG_WIN = 2;
    static final int DRAW = 0;
    static final int EXCEPTION = -1;

    static final int BOOK_START_PAGE = 1;
    static final int BOOK_END_PAGE = 400;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // validate inputs
        if (isWrongInput(pobi) || isWrongInput(crong)) {
            return EXCEPTION;
        }

        String pobiLeft = pobi.get(LEFT) + "";
        String pobiRight = pobi.get(RIGHT) + "";
        String crongLeft = crong.get(LEFT) + "";
        String crongRight = crong.get(RIGHT) + "";

        int pobiMaxScore = Math.max(getMaxScore(pobiLeft), getMaxScore(pobiRight));
        int crongMaxScore = Math.max(getMaxScore(crongLeft), getMaxScore(crongRight));

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
        boolean isValid = true;

        // 입력값이 정렬이 안 된 경우 (왼쪽 >= 오른쪽)
        if (isNotSorted(left, right)) {
            isValid = false;
        }
        // 왼쪽 페이지, 오른쪽 페이지의 번호 차이가 1보다 큰 경우
        if (getDifference(left, right) > 1) {
            isValid = false;
        }
        // 1 이하, 400이상 입력값이 들어온 경우
        if (isOutOfBound(left, right)) {
            isValid = false;
        }

        return isValid;
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