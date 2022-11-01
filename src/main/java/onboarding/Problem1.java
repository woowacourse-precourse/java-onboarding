package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isIncorrectPages(pobi) | isIncorrectPages(crong)) {
            return -1;
        }

        int pobiScore = getMaxScore(pobi);
        int crongScore = getMaxScore(crong);

        return compareScore(pobiScore, crongScore);
    }

    private static boolean isIncorrectPages(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        boolean isPagePair = rightPage % 2 == 0 &
                (leftPage + 1) == rightPage;
        boolean isCorrectPageRange = 1 <= leftPage & rightPage <= 400;

        return !(isPagePair & isCorrectPageRange);
    }

    private static int getMaxScore(List<Integer> pages) {
        return pages.stream()
                .mapToInt(i -> toScore(i))
                .max()
                .getAsInt();
    }

    private static int toScore(int page) {
        int addedResult = 0;
        int multipliedResult = 1;

        for (int i = getMaxPlaceValue(page); i > 0; i /= 10) {
            int score = page / i;
            page %= i;

            addedResult += score;
            multipliedResult *= score;
        }

        return Math.max(addedResult, multipliedResult);
    }

    private static int getMaxPlaceValue(int page) {
        int placeValue = (int) (Math.log10(page));
        int result = 1;

        for (int i = 0; i < placeValue; i++) {
            result *= 10;
        }

        return result;
    }

    private static int compareScore(int scoreA, int scoreB) {
        int result = 0;

        if (scoreA > scoreB) {
            result = 1;
        } else if (scoreA < scoreB) {
            result = 2;
        }

        return result;
    }
}