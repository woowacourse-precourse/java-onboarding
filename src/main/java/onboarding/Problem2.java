package onboarding;

import java.util.Stack;

public class Problem2 {
    private static boolean isAllLowerCase(String cryptogram)
    {
        int i = 0;
        int len = cryptogram.length();

        while (i < len && Character.isLowerCase(cryptogram.charAt(i))) {
            i++;
        }
        return (i == len);
    }
    private static boolean isValidLength(String cryptogram)
    {
        int len = cryptogram.length();

        return (0 < len && len < 1001);
    }
    private static boolean isValidCryptogram(String cryptogram)
    {
        return (cryptogram != null && isAllLowerCase(cryptogram) && isValidLength(cryptogram));
    }
    private static void removeDuplicate(Stack<Character> stack)
    {
        if (stack.size() == 1)
            return;
        if (stack.peek() == stack.elementAt(stack.size() - 2))
        {
            stack.pop();
            stack.pop();
        }
    }
    private static Stack<Character> deciper(String cryptogram)
    {
        Stack<Character> stack = new Stack<>();
        int len = cryptogram.length();

        for (int i = 0; i < len; i++) {
            stack.push(cryptogram.charAt(i));
            removeDuplicate(stack);
        }
        return (stack);
    }
    public static String solution(String cryptogram) {
        if (!isValidCryptogram(cryptogram))
            throw (new RuntimeException("유효하지 않은 문자열"));
        return ("");
    }
}
