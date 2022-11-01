package onboarding;

import java.util.List;

class Problem1 {

    static final int LEFT_PAGE = 0;
    static final int RIGHT_PAGE = 1;
    static final int POBI_WIN = 1;
    static final int CRONG_WIN = 2;
    static final int DRAW = 0;
    static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(isCorrectPage(pobi) && isCorrectPage(crong))) {
            return EXCEPTION;
        }
        return compareMaxValue(pobi, crong);
    }
    public static boolean isCorrectPage(List<Integer> name) {
        if (name.get(LEFT_PAGE) % 2 == 1 && name.get(RIGHT_PAGE) - name.get(LEFT_PAGE) == 1) {
            return true;
        }
        return false;
    }

    public static int findMaxValue(Integer page) {
        return Math.max(addPageNumber(page), multiplyPageNumber(page));
    }
}

