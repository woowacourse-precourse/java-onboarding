package onboarding;

import java.util.List;

class ScoreCalculator {

    private static class ScoreCalculatorHolder {
        private static final ScoreCalculator INSTANCE = new ScoreCalculator();
    }

    private ScoreCalculator() {

    }

    public static ScoreCalculator getInstance() {
        return ScoreCalculatorHolder.INSTANCE;
    }

    public int getScore(List<Integer> playerPages) {
        int maxScore = Integer.MIN_VALUE;

        for (int len = playerPages.size(), i = 0; i < len; i++) {
            int page = playerPages.get(i);
            int score = getPageScore(page);
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }

    private int getPageScore(int page) {
        int sumScore = getSumScore(page);
        int productScore = getProductScore(page);

        return Math.max(sumScore, productScore);
    }

    private int getSumScore(int page) {
        String pageStr = String.valueOf(page);
        int sum = 0;

        for (int len = pageStr.length(), i = 0; i < len; i++) {
            sum += pageStr.charAt(i) - '0';
        }

        return sum;
    }

    private int getProductScore(int page) {
        String pageStr = String.valueOf(page);
        int product = 1;

        for (int len = pageStr.length(), i = 0; i < len; i++) {
            product *= pageStr.charAt(i) - '0';
        }

        return product;
    }

}

class Problem1 {

    private static final int START_PAGE_NO = 1;
    private static final int END_PAGE_NO = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validate(pobi) || !validate(crong)) {
            return -1;
        }

        ScoreCalculator scoreCalculator = ScoreCalculator.getInstance();
        int pobiScore = scoreCalculator.getScore(pobi);
        int crongScore = scoreCalculator.getScore(crong);

        int answer = getWinner(pobiScore, crongScore);
        return answer;
    }

    private static boolean validate(List<Integer> pages) {
        return validPagesCount(pages) && validPagesRange(pages);
    }

    private static boolean validPagesCount(List<Integer> pages) {
        return pages.size() == 2;
    }

    private static boolean validPagesRange(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (!isLeftPage(leftPage) || !isRightPage(rightPage)) {
            return false;
        }

        if (!isContinuousPage(leftPage, rightPage)) {
            return false;
        }

        return !isStartPage(leftPage) && !isEndPage(rightPage);
    }

    private static boolean isLeftPage(int leftPage) {
        return (leftPage & 1) == 1;
    }

    private static boolean isRightPage(int rightPage) {
        return (rightPage & 1) == 0;
    }

    private static boolean isContinuousPage(int leftPage, int rightPage) {
        return rightPage - leftPage == 1;
    }

    private static boolean isStartPage(int leftPage) {
        return leftPage == START_PAGE_NO;
    }

    private static boolean isEndPage(int rightPage) {
        return rightPage == END_PAGE_NO;
    }

    private static int getWinner(int score1, int score2) {
        if (score1 > score2) {
            return 1;
        }

        if (score1 < score2) {
            return 2;
        }

        return 0;
    }

}