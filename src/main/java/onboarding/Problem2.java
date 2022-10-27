package onboarding;

import java.util.Stack;

public class Problem2 {

    private static Stack<Character> characterStack;

    public static String solution(String cryptogram) {
        initStack(cryptogram);
        return deleteDuplicateChars(cryptogram);
    }

    private static String deleteDuplicateChars(String cryptogram) {
        for(int i=1; i<cryptogram.length(); i++) {
            if(validateSameChar(characterStack.peek(), cryptogram.charAt(i))) {
                characterStack.pop();
                continue;
            }

            characterStack.push(cryptogram.charAt(i));
        }

        return CharsToString();
    }

    private static boolean validateSameChar(char char1, char char2) {
        return char1 == char2;
    }

    private static void initStack(String cryptogram) {
        characterStack = new Stack<>();
        characterStack.push(cryptogram.charAt(0));
    }

    private static String CharsToString() {
        StringBuilder sb = new StringBuilder();

        if(characterStack.empty()) {
            return "";
        }

        characterStack.forEach(sb::append);
        return sb.toString();
    }
}
