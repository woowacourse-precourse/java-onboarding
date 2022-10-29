package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pScore = maxScore(pobi);
        int cScore = maxScore(crong);

        if (pScore > cScore)
            return 1;
        else if (pScore < cScore)
            return 2;
        return 0;
    }

    private static int maxScore(List<Integer> pages) {
        int maxSco = 0;

        for(Integer page : pages)
            maxSco = Math.max(maxSco, pageScore(page));

        return maxSco;
    }

    private static int pageScore(Integer page) {
        int add = 0, mul = 1;

        while(page > 0) {
            add += page % 10;
            mul *= page % 10;
            page /= 10;
        }

        return Math.max(add, mul);
    }
}