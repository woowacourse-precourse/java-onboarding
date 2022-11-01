package onboarding.problem1;

import java.util.List;

import static onboarding.problem1.Calculator.getScore;
import static onboarding.problem1.Validator.validate;

public class Comparator {
    static final int ERROR = -1;
    static final int DRAW = 0;
    static final int POBI_WIN = 1;
    static final int CRONG_WIN = 2;
    public static int decideWinner(List<Integer> pobi, List<Integer> crong){
        if (isError(pobi, crong)) { return ERROR;}
        return compareScore(pobi, crong);
    }

    private static int compareScore(List<Integer> pobi, List<Integer> crong) {
        if (isDraw(pobi, crong)) {
            return DRAW;
        }
        if (isWinnerPobi(pobi, crong)) {
            return POBI_WIN;
        }
        return CRONG_WIN;
    }

    private static boolean isWinnerPobi(List<Integer> pobi, List<Integer> crong) {
        return getScore(pobi) > getScore(crong);
    }

    private static boolean isDraw(List<Integer> pobi, List<Integer> crong) {
        return getScore(pobi) == getScore(crong);
    }

    private static boolean isError(List<Integer> pobi, List<Integer> crong) {
        return !(validate(pobi) && validate(crong));
    }
}
