package onboarding.problem2;

import java.util.Stack;

public class Determine {

    public String compare(Stack<String> cryptogram) {

        StringBuilder result = new StringBuilder();

        for (String str : cryptogram) {
            result.append(str);
        }

        return result.toString();
    }
}
