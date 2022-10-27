package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> decodedCryptogram = deleteDuplicateChars(initStack(cryptogram), cryptogram);

        return answer;
    }

    private static Stack<Character> deleteDuplicateChars(Stack<Character> characterStack, String cryptogram) {
        for(int i=0; i<cryptogram.length(); i++) {
            if(validateSameChar(characterStack.peek(), cryptogram.charAt(i))) {
                characterStack.pop();
            }
        }

        return characterStack;
    }

    private static boolean validateSameChar(char char1, char char2) {
        return char1 == char2;
    }

    private static Stack<Character> initStack(String cryptogram) {
        Stack<Character> characterStack = new Stack<>();
        characterStack.push(cryptogram.charAt(0));
        return characterStack;
    }
}
