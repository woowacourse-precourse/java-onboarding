package onboarding;

import onboarding.prob2.domain.Processor;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Processor processor = new Processor();
        answer = processor.solve(cryptogram);
        return answer;
    }
}
