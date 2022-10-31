package onboarding;

import onboarding.problem1.Validator;
import java.util.List;
import static onboarding.problem1.Operator.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(Validator.validate(pobi) && Validator.validate(crong))) { return -1;}
        if (compare(pobi) == compare(crong)) {
            answer = 0;
        }
        else if (compare(pobi) > compare(crong)) {
            answer = 1;
        }
        else {
            answer = 2;
        }

        return answer;
    }
}