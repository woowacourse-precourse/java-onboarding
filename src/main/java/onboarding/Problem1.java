package onboarding;

import java.util.List;

class Problem1 {
    private static final int PAGE_SIZE = 2;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 500;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidInput(pobi) || !isValidInput(crong)) {
            return -1;
        }

        int scorePobi = getMaxScore(pobi);
        int scoreCrong = getMaxScore(crong);

        return compareScore(scorePobi, scoreCrong);
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

    private static int calculateDigits(Integer number) {
        int sum = 0;
        int mul = 1;

        while (number > 0) {
            sum += (number % 10);
            mul *= (number % 10);
            number /= 10;
        }

        return Math.max(sum, mul);
    }

    private static int getMaxScore(List<Integer> pages) {
        int answer = Integer.MIN_VALUE;

        for (Integer page : pages) {
            answer = Math.max(answer, calculateDigits(page));
        }

        return answer;
    }

    private static int compareScore(int scorePobi, int scoreCrong) {
        if (scorePobi > scoreCrong) {
            return 1;
        }

        if (scorePobi < scoreCrong) {
            return 2;
        }

        return 0;
    }
}
