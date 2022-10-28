package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static Stack<Character> removeDuplication(String cryptogram) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {

            char currentChar = cryptogram.charAt(i);

            if(!stack.isEmpty() && stack.peek() == currentChar) {
                i += getEqualCharCount(cryptogram, i + 1, currentChar);
                stack.pop();
                continue;
            }

            stack.add(currentChar);

        }

        return stack;
    }

    static int getEqualCharCount(String cryptogram, int index, char currentChar) {

        int equalCount = 0;

        while(index < cryptogram.length()) {

            if(cryptogram.charAt(index) != currentChar)
                return equalCount;

            index++;
            equalCount++;
        }

        return equalCount;
    }
}
