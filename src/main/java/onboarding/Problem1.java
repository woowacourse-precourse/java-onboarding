package onboarding;

import java.util.List;

class ScoreCalculator {

    private final List<Integer> playerPages;

    public ScoreCalculator(final List<Integer> playerPages) {
        this.playerPages = playerPages;
    }

    public int getScore() {
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
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}