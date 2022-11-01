package onboarding;

import onboarding.problem2.Determine;
import onboarding.problem2.AnalyticalGenerator;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        AnalyticalGenerator generator = new AnalyticalGenerator();
        Stack<String> passwordStack = generator.analyzer(cryptogram);

        Determine determine = new Determine();
        String answer = determine.compare(passwordStack);

        return answer;
    }
}
