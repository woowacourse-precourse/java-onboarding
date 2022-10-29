package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        System.out.println(deleteDuplicatedChar(answer.toCharArray()));
        return answer;
    }

    public static String deleteDuplicatedChar(char[] cryptogramCharArray) {
        Stack<Character> characterStack = new Stack<>();
        boolean flag = false;

        for (char nextChar :
                cryptogramCharArray) {
            if (!characterStack.isEmpty()) {
                if (characterStack.peek() != nextChar) {
                    characterStack.push(nextChar);
                    continue;
                }
            }
            characterStack.push(nextChar);
        }

        return characterStack.toString();

    }
}