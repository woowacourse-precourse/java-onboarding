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

    // Multiplication method: multiply all digits and return max value
    public static int multiplyPages(List<Integer> pages) {
        int result = 1;

        for (int page : pages) {

            int currentScore = 1;

            while (page > 0) {
                int temp = page % 10;
                currentScore *= temp;
                page /= 10;
            }

            if (currentScore > result) {
                result = currentScore;
            }
        }

        return result;
    }

    // Sum method: add all digits and return max value
    public static int addPages(List<Integer> pages) {
        int result = 0;

        for (int page : pages) {

            int currentScore = 0;

            while (page > 0) {
                int temp = page % 10;
                currentScore += temp;
                page /= 10;
            }

            if (currentScore > result) {
                result = currentScore;
            }
        }

        return result;
    }
}