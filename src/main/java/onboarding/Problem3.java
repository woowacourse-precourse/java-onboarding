package onboarding;

import onboarding.problem3.domain.Numbers;

public class Problem3 {
    public static int solution(int number) {
        return new Numbers(number).sumCountOfMultipleOfThree();
    }
}
