package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (validPages(pobi) || validPages(crong)) {
            return -1;
        }
        return answer;
    }

    private static boolean validPages(List<Integer> pages) {
        if (isNotPairPages(pages)) {
            return true;
        }
        return isFirstPageAndLastPage(pages);
    }

    private static boolean isNotPairPages(List<Integer> pages) {
        return pages.get(1) - pages.get(0) != 1;
    }

    private static boolean isFirstPageAndLastPage(List<Integer> pages) {
        return pages.get(0) == 1 || pages.get(1) == 400;
    }
}
