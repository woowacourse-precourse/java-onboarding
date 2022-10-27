package onboarding;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeDuplication(cryptogram);
        System.out.println(answer);
        return answer;
    }

    public static String removeDuplication(String cryptogram) {
        Stack<Character> cryptoStack = new Stack<>();
        cryptoStack.push(cryptogram.charAt(0));
        cryptogram = cryptogram.substring(1);
        for (char c: cryptogram.toCharArray()) {
            if (cryptoStack.peek() != c) {
                cryptoStack.push(c);
            } else {
                cryptoStack.pop();
            }
        }

        String answer = "";
        while(cryptoStack.isEmpty() == false) {
            answer = cryptoStack.pop() + answer;
        }
        return answer;
    }
}
