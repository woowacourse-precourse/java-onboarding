package onboarding;

import java.util.List;
import onboarding.problem1.Calculator;
import onboarding.problem1.InputException;

class Problem1 {
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (InputException.validationCheck(pobi) && InputException.validationCheck(crong)) {
            Calculator pobiCalculator = new Calculator(pobi);
            Calculator crongCalculator = new Calculator(crong);

            int pobiScore = pobiCalculator.getScore();
            int crongScore = crongCalculator.getScore();

            if (pobiScore == crongScore) {
                return DRAW;
            }
            return pobiScore > crongScore ? POBI_WIN : CRONG_WIN;
        }
        return EXCEPTION;
    }
}