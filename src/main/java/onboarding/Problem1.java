package onboarding;

import java.util.List;

import static onboarding.validator.PageNumberValidator.isValidPageNumbers;

class Problem1 {

    public static final int EXCEPTION = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            isValidPageNumbers(pobi);
            isValidPageNumbers(crong);
            return 0;
        } catch (IllegalArgumentException e) {
            return EXCEPTION;
        }
    }
}