package onboarding;

import problem1.CompareScore;
import problem1.Page;
import java.util.List;

class Problem1 {
    private static final CompareScore compareScore = new CompareScore();

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Page pobiPage = new Page(pobi.get(0), pobi.get(1));
        Page crongPage = new Page(crong.get(0), crong.get(1));

        if (!pobiPage.checkPage() || !crongPage.checkPage())
            return -1;

        return compareScore.compare(pobiPage.getMaxValue(), crongPage.getMaxValue());
    }
}