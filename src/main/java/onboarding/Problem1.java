package onboarding;

import java.util.List;

class Problem1 {
    static final int FIRST_PAGE = 1;
    static final int LAST_PAGE = 400;
    static final int LEFT_PAGE = 0;
    static final int RIGHT_PAGE = 1;

    static final int EXCEPTION = -1;
    static final int WIN_POBI = 1;
    static final int WIN_CRONG = 2;
    static final int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MIN_VALUE;

        // 첫 페이지 혹은 끝 페이지 포함하는지 확인
        if (isHavingFirstPage(pobi) || isHavingLastPage(pobi)
                || isHavingFirstPage(crong) || isHavingLastPage(crong)) {
            return EXCEPTION;
        }

        return answer;
    }

    public static boolean isHavingFirstPage(List<Integer> openPages) {
        return openPages.contains(FIRST_PAGE);
    }

    public static boolean isHavingLastPage(List<Integer> openPages) {
        return openPages.contains(LAST_PAGE);
    }
}