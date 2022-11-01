package onboarding;

import java.util.List;

public class Problem1 {
    public static final int START = 1;
    public static final int END = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Page pobiPage = new Page(pobi.get(0), pobi.get(1));
        Page crongPage = new Page(crong.get(0), crong.get(1));

        return getAnswer(pobiPage, crongPage);
    }

    public static int getAnswer(Page pobiPage, Page crongPage) {
        if (pobiPage.validatePage() & crongPage.validatePage()) {
            if (pobiPage.getScore() > crongPage.getScore()){
                return 1;
            }
            if (pobiPage.getScore() < crongPage.getScore()){
                return 2;
            }
            if (pobiPage.getScore() == crongPage.getScore()){
                return 0;
            }
        }
        return -1;
    }
}