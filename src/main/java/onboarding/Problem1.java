package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isNotValidPages(pobi) || isNotValidPages(crong)) {
            return -1;
        }

        return 0;
    }

    private static boolean isNotValidPages(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return true;
        }

        if (rightPage - leftPage != 1 || rightPage > 400) {
            return true;
        }

        return false;
    }
}