package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int getScore(int pageNumber) {
        int score = 0;
        int pageMult = 1;
        int pageSum = 0;
        while (pageNumber > 0) {
            int digit = pageNumber % 10;
            pageMult *= digit;
            pageSum += digit;
            pageNumber = pageNumber / 10;
        }
        score = Math.max(pageMult, pageSum);
        return score;
    }

}