package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidPages(pobi) || isInvalidPages(crong)) {
            return -1;
        }

        return 0;
    }

    private static boolean isInvalidPages(List<Integer> pages) {
        if (pages.get(1) - pages.get(0) != 1) {
            return true;
        }

        if (pages.get(0) % 2 == 0 || pages.get(1) % 2 == 1) {
            return true;
        }

        return false;
    }
}