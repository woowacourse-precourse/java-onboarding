package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePage(pobi) || !validatePage(crong)) {
            return -1;
        }

        return 0;
    }

    private static boolean validatePage(List<Integer> pages) {
        final int FIRST_PAGE = 0;
        final int SECOND_PAGE = 1;

        boolean result = isSequentialPage(pages.get(FIRST_PAGE), pages.get(SECOND_PAGE));
        if (isFirstOrLastPage(pages.get(FIRST_PAGE), pages.get(SECOND_PAGE))) {
            result = false;
        }
        return result;
    }

    private static boolean isSequentialPage(int first, int last) {
        return (last - 1) == first;
    }

    private static boolean isFirstOrLastPage(int first, int second) {
        final int FIRST_PAGE_NUM = 1;
        final int LAST_PAGE_NUM = 400;

        return first == FIRST_PAGE_NUM || second == LAST_PAGE_NUM;
    }
}