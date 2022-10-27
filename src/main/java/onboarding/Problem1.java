package onboarding;

import java.util.List;

class Problem1 {
    private final static int EXCEPTIONS_NUMBER = -1;
    private static final int DRAW_NUMBER = 0;
    private static final int WIN_POBI_NUMBER = 1;
    private static final int WIN_CRONG_NUMBER = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        if (isNotTwoElements(pobi) || isNotSidePage(pobi)) {
            return EXCEPTIONS_NUMBER;
        }

        if (isNotTwoElements(crong) || isNotSidePage(crong)) {
            return EXCEPTIONS_NUMBER;
        }

        return answer;
    }

    private static boolean isNotTwoElements(List<Integer> checkList) {
        return checkList.size() != 2;
    }

    private static boolean isNotSidePage(List<Integer> checkList) {
        return checkList.get(0) != checkList.get(1) - 1;
    }
}