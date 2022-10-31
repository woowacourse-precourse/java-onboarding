package onboarding;

import calculator.Calculator;
import validator.ProblemOneValidator;

import java.util.List;

class Problem1 {
    private static final int FAIL = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int validate = ProblemOneValidator.validate(pobi, crong);
        if (validate == FAIL) {
            return FAIL;
        }

        int pobiNumber = Calculator.getBiggerNumber(pobi);
        int crongNumber = Calculator.getBiggerNumber(crong);

        return Calculator.getResult(pobiNumber, crongNumber);
    }
}