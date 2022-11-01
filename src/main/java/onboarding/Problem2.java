package onboarding;

import java.util.Stack;

import static onboarding.problem2.Operator.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> cryptogramStack = makeStringToStack(cryptogram);
        Stack<Character> filteredStack = deleteDuplicate(cryptogramStack);

        return makeStackToString(filteredStack);
    }
}
