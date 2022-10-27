package onboarding;

import onboarding.problem2.Determine;
import onboarding.problem2.StackGenerator;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        StackGenerator generator = new StackGenerator();
        Stack<String> passwordStack = generator.createStack(cryptogram);

        Determine determine = new Determine();
        String answer = determine.compare(passwordStack);

        return answer;
    }
}
