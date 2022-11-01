package onboarding;

import onboarding.problem3.Number;

public class Problem3 {
    public static int solution(int number) {
        Number n = new Number(number);
        return (int) n.getClap();
    }
}
