package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            int pScore = maxScore(pobi);
            int cScore = maxScore(crong);

            if (pScore > cScore)
                return 1;
            else if (pScore < cScore)
                return 2;
            return 0;
        } catch(Exception e) {
            return -1;
        }
    }

    private static int maxScore(List<Integer> pages) throws Exception {
        return 0;
    }
}