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
        int answer = Integer.MAX_VALUE;
        return answer;
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