package onboarding;

import onboarding.problem3.IterativeGenerator;

public class Problem3 {
    public static int solution(int number) {

        IterativeGenerator generator = new IterativeGenerator();
        int answer = generator.typeConversion(number);

        return answer;
    }
}
