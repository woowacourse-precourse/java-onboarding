package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> cryptogramStack = new Stack<>();
        char[] charCryptogramArray = cryptogram.toCharArray();

        int index = 0;

        while (index < charCryptogramArray.length) {
            if (!cryptogramStack.isEmpty() && cryptogramStack.peek().equals(charCryptogramArray[index])) {
                cryptogramStack.pop();
            } else {
                cryptogramStack.add(charCryptogramArray[index]);
            }
            index++;
        }

        for (char alphabet : cryptogramStack) {
            answer += alphabet;
        }

        return answer;
    }
}
