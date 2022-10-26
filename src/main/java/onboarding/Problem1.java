package onboarding;

import java.util.List;

class Problem1 {
    public static boolean validator(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        return leftPage > 0 && leftPage < 400 && rightPage > 1 && rightPage <= 400 && rightPage - leftPage == 1;
    }

    public static int calcScore(List<Integer> pages) {
        int[] scores = { 0, 0 };
        for (int i = 0; i < pages.size(); i++) {
            int page = pages.get(i);

            int plusScore = 0, multiScore = 1;
            while (page != 0) {
                int score = page % 10;
                plusScore += score;
                multiScore *= score;

                page /= 10;
            }

            scores[i] = Math.max(plusScore, multiScore);
        }

        return Math.max(scores[0], scores[1]);
    }
    
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}