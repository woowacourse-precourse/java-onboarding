package onboarding;

import onboarding.problem3.ClapCounter;

public class Problem3 {
    public static int solution(int number) {
        ClapCounter clapCounter = new ClapCounter(number);
        return clapCounter.count();
    }
}
