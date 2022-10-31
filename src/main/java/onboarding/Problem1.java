package onboarding;

import onboarding.problem1.Comparator;
import onboarding.problem1.Validator;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(Validator.validate(pobi) && Validator.validate(crong))) { return -1;}
        if (Comparator.compare(pobi) == Comparator.compare(crong)) {
            answer = 0;
        }
        else if (Comparator.compare(pobi) > Comparator.compare(crong)) {
            answer = 1;
        }
        else {
            answer = 2;
        }

        return answer;
    }
}