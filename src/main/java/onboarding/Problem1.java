package onboarding;

import java.util.List;

class Problem1 {
    private static final int length = 2;
    private static final int minPage = 3;
    private static final int maxPage = 398;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!validatePage(pobi) || !validatePage(crong)) {
            return -1;
        }
        return answer;
    }

    private static boolean validatePage(List<Integer> pages) {
        int leftIdx = 0;
        int rightIdx = 1;

        if(pages.size() != length) {
            return false;
        }
        if(!pageInRange(pages)) {
            return false;
        }
        if(pages.get(leftIdx) % 2 == 0 || pages.get(rightIdx) % 2 != 0) {
            return false;
        }
        return pages.get(leftIdx) + 1 == pages.get(rightIdx);
    }

    private static boolean pageInRange(List<Integer> pages) {
        return pages.stream()
            .allMatch(page -> page >= minPage && page <= maxPage);
    }
}