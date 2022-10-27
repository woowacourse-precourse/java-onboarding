package onboarding;

import java.util.List;

class Problem1 {
    private static final int PAGE_SIZE = 2;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 500;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!isValidInput(pobi) || !isValidInput(crong)) {
            return -1;
        }

        return answer;
    }

    private static boolean isValidInput(List<Integer> pages) {
        if (pages.size() != PAGE_SIZE) {
            return false;
        }

        if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }

        if (pages.get(0) < FIRST_PAGE || pages.get(1) > LAST_PAGE) {
            return false;
        }

        if (pages.get(0) % 2 != 1 || pages.get(1) % 2 != 0) {
            return false;
        }

        return true;
    }
}
