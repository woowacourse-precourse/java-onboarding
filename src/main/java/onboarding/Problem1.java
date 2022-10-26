package onboarding;

import java.util.List;

class Problem1 {
    static final int PAGE_MIN = 1;
    static final int PAGE_MAX = 399;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean isValid(List<Integer> page) {
        int frontPage = page.get(0);
        int endPage = page.get(1);
        if((PAGE_MIN < frontPage && frontPage < PAGE_MAX) && frontPage % 2 == 1){
            return endPage - frontPage == 1;
        }
        return false;
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