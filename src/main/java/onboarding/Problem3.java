package onboarding;

import onboarding.problem3.CheckNumber;

public class Problem3 {
    public static int solution(int number) {
        if (!CheckNumber.of(number)){
            throw new IllegalArgumentException("number는 1이상 10,000 이하인 자연수이여야 한다.");
        }
        int answer = 0;
        return answer;
    }
}
