package onboarding;

import onboarding.problem1.Validator;
import java.util.List;
import static onboarding.problem1.Operator.*;

class Problem1 {
    static final int DRAW = 0;
    static final int POBI = 1;
    static final int CRONG = 2;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(Validator.validate(pobi) && Validator.validate(crong))) { return -1;}
        if (compare(pobi) == compare(crong)) {
            answer = DRAW;
        }
        else if (compare(pobi) > compare(crong)) {
            answer = POBI;
        }
        else {
            answer = CRONG;
        }

        return answer;
    }
}