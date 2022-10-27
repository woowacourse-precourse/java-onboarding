package onboarding;

import onboarding.problem3.CheckNumber;
import onboarding.problem3.Game369;

public class Problem3 {
    public static int solution(int number) {
        if (!CheckNumber.of(number)){
            throw new IllegalArgumentException("number는 1이상 10,000 이하인 자연수이여야 한다.");
        }
        return Game369.getGame369sum(number);
    }
}
