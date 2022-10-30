package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 1. Validation check
        boolean pobiCheck = validationCheck(pobi);
        boolean crongCheck = validationCheck(pobi);

        if (!pobiCheck || !crongCheck) {
            return -1;
        }

        // 2-1. Calculate the maximum score of pobi
        int pobiScore = Math.max(multiplyPages(pobi), addPages(pobi));

        // 2-2. Calculate the maximum score of crog
        int crongScore = Math.max(multiplyPages(crong), addPages(crong));

        int answer = 0;

        // 3. Find and return answer
        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
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