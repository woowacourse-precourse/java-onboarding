package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        
        StringBuilder answer = new StringBuilder();
        Stack<Character> cryptoStack = new Stack<>();
        char[] parseCryptoArr = cryptogram.toCharArray();

        cryptoStack.push(parseCryptoArr[0]);

        deleteDuplicateCryptoStack(cryptoStack, parseCryptoArr);
        sortReverseCryptoStack(answer, cryptoStack);

        return answer.toString();
    }

    private static void sortReverseCryptoStack(StringBuilder answer, Stack<Character> cryptoStack) {
        for (int i = 0; i < cryptoStack.size(); i++) {
            answer.append(cryptoStack.elementAt(i));
        }
    }

    private static void deleteDuplicateCryptoStack(Stack<Character> cryptoStack, char[] parseCryptoArr) {
        for (int i = 1; i < parseCryptoArr.length; i++) {
            if (cryptoStack.peek() == parseCryptoArr[i]) {
                cryptoStack.pop();
                continue;
            }
            cryptoStack.push(parseCryptoArr[i]);
        }
    }
}
