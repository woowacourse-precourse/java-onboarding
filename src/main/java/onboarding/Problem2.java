package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] alphabetArray = cryptogram.toCharArray();
        return getUniqueWord(alphabetArray);
    }

    private static String getUniqueWord(char[] alphabetArray) {
        Stack<Character> stack = new Stack<>();
        deleteDuplicatedAlphabet(stack, alphabetArray);

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private static void deleteDuplicatedAlphabet(Stack<Character> stack, char[] alphabetArray) {
        char lastDeletedAlphabet = ' ';
        for (char alphabet : alphabetArray) {
            if (stack.isEmpty()) {
                stack.push(alphabet);
                continue;
            }
            char forefrontAlphabet = stack.peek();
            if (alphabet == forefrontAlphabet) {
                stack.pop();
                lastDeletedAlphabet = alphabet;
                continue;
            }
            if (alphabet == lastDeletedAlphabet) {
                continue;
            }
            stack.push(alphabet);
            lastDeletedAlphabet = ' ';
        }
    }
}