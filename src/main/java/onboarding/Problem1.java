package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidePages(pobi) || !isValidePages(crong)) {
            return -1;
        };
        return 0;
    }

    private static boolean isValidePages(List<Integer> pages) {
        if (pages.size() != 2) {
            return false;
        }
        if (!(isLeftPage(pages) && isNextPage(pages))) {
            return false;
        }
        return true;
    }

    private static boolean isLeftPage(List<Integer> pages) {
        return pages.get(0) % 2 == 1;
    }

    private static boolean isNextPage(List<Integer> pages) {
        return pages.get(0) + 1 == pages.get(1);
    }

}