package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String getStringFromStack(Stack<Character> stack) {
        String text = "";
        while(!stack.isEmpty()) {
            text += stack.peek();
            stack.pop();
        }
        StringBuffer answerBuffer = new StringBuffer(text).reverse();
        return answerBuffer.toString();
    }

    public static void removeDuplicateCharacter(Stack<Character> stack, Integer dupliCount) {
        for (int i=0; i<dupliCount; i++) {
            stack.pop();
        }
    }

    public static boolean isDuplicate(String cryptogram) {
        for (int i=0; i<cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    public static String remove(String cryptogram, Stack<Character> stack) {
        int dupliCount = 1;
        boolean isDuplicate = false;
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.isEmpty() && cryptogram.charAt(i) == stack.peek()) {
                isDuplicate = true;
                dupliCount += 1;
                if (i == cryptogram.length() - 1 && (isDuplicate || cryptogram.length() == 2)) {
                    stack.push(cryptogram.charAt(i));
                    removeDuplicateCharacter(stack, dupliCount);
                    break;
                }
            } else if (!stack.isEmpty() && cryptogram.charAt(i) != stack.peek() && isDuplicate) {
                removeDuplicateCharacter(stack, dupliCount);
                dupliCount = 1;
                isDuplicate = false;
            }
            stack.push(cryptogram.charAt(i));
        }
        return getStringFromStack(stack);
    }

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        while (true) {
            cryptogram = remove(cryptogram,stack);
            if (!isDuplicate(cryptogram)) {
                break;
            }
        }
        return cryptogram;
    }

}

