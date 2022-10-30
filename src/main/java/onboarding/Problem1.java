package onboarding;

import java.util.List;

class Problem1 {
    public static final int EXCEPTION = -1;
    public static final int DRAW = 0;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int MIN_PAGE = 1;
    public static final int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isException(pobi) || isException(crong))
            return EXCEPTION;
    }

    public static boolean isException(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        if(left < MIN_PAGE || left > MAX_PAGE || right < MIN_PAGE || right > MAX_PAGE)
            return true;
        if(left % 2 == 0 || right % 2 != 0)
            return true;
        if(left >= right || right - left > 1)
            return true;

        return false;
    }

}