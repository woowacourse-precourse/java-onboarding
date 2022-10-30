package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 1. Validation check
        boolean pobiCheck = validationCheck(pobi);
        boolean crongCheck = validationCheck(pobi);

        if (!pobiCheck || !crongCheck) {
            return -1;
        }

        return answer;
    }

    // Validation method: check if the pages are valid
    private static boolean validationCheck(List<Integer> pages) {
        return pages.get(0) + 1 == pages.get(1);
    }

}