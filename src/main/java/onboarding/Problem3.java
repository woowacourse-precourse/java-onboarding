package onboarding;

import onboarding.prob3.domain.ClapCounter;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        ClapCounter clapCounter = new ClapCounter();
        answer = clapCounter.solve(number);
        return answer;
    }
}
