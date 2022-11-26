package onboarding.resolve.problem1;

import java.util.List;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MIN_VALUE;
        if (!ExceptionHandler.validateInput(pobi) || !ExceptionHandler.validateInput(crong)) {
            return Constants.EXCEPTION;
        }

        return answer;
    }
}
