package onboarding;

import java.util.Stack;

public class Problem2 {
    private static final int MAX = 1000;
    private static final int MIN = 1;
    private static Character SameBeforeCharacter;

    public static String solution(String cryptogram) {
        if (!canCryptogram(cryptogram) && !isStringLowerCase(cryptogram))
            throw new IllegalArgumentException("제한 사항을 위반하였습니다.");
        return deleteOverlapCharacter(cryptogram);
    }

    public static String deleteOverlapCharacter(String cryptogram) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!s.isEmpty() && s.peek() == cryptogram.charAt(i)) {
                s.pop();
                SameBeforeCharacter = cryptogram.charAt(i);
                continue;
            }

            s.push(cryptogram.charAt(i));
        }
        if (!s.isEmpty() && s.peek() == SameBeforeCharacter) {
            s.pop();
        }


        return getChangeCryptogram(s);
    }

    public static String getChangeCryptogram(Stack<Character> s) {
        String reverse_result = "";
        while (!s.isEmpty()) {
            reverse_result += s.peek();
            s.pop();
        }
        String result = "";
        for (int i = reverse_result.length() - 1; i >= 0; i--) {
            result += reverse_result.charAt(i);
        }
        return result;
    }

    public static boolean canCryptogram(String cryptogram) {
        if ((cryptogram.length() >= MIN && cryptogram.length() <= MAX)) return true;
        return false;
    }

    public static boolean isStringLowerCase(String cryptogram) {
        char[] cryptogramArray = cryptogram.toCharArray();
        for (int i = 0; i < cryptogramArray.length; i++) {
            if (Character.isUpperCase(cryptogram.charAt(i))) return false;
        }
        return true;
    }

}
