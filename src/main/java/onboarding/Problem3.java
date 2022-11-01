package onboarding;

import onboarding.problem3.Validator;

import static onboarding.problem3.Counter.count369;

public class Problem3 {
    public static int solution(int number) {
        if(!Validator.validate(number)){return -1;}
        return count369(number);
    }
}
