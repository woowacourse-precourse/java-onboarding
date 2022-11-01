package onboarding;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        Page pobiPage = new Page(pobi);
        Page crongPage = new Page(crong);

        if ((!pobiPage.validationCheck() || !crongPage.validationCheck())) {
            return EXCEPTION;
        }
        Page pobiWithMaxValue = pobiPage.findMaxValue("pobi");
        Page crongWithMaxValue = crongPage.findMaxValue("crong");

        int winner = pobiWithMaxValue.findMaxValue(crongWithMaxValue);

        return winner;
    }
}
