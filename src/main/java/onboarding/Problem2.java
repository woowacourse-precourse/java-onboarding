package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!validate(cryptogram)) return "Invalid Input";

        Stack<Character> nonDuplicates = decryption(cryptogram);

        String answer = concatStack(nonDuplicates);

        return answer;
    }

    private static boolean validate(String cryptogram) {
        if (cryptogram.length() > 1000 || cryptogram.length() < 1) return false;

        for (int i = 0; i < cryptogram.length(); i++) {
            if (Character.isUpperCase(cryptogram.charAt(i))) return false;
        }

        return true;
    }

    private static Stack<Character> decryption(String input) {
        Stack<Character> result = new Stack<>();
        Character duplicate = null;

        for (int i = 0; i < input.length(); i++) {
            Character cur = input.charAt(i);

            if (result.isEmpty() && duplicate == null) {
                result.push(cur);
                continue;
            }

            if (!result.isEmpty() && result.peek() == cur) {
                duplicate = cur;
                result.pop();
                continue;
            }

            if (duplicate != cur) {
                result.push(cur);
            }
        }

        return result;
    }

    private static String concatStack(Stack<Character> nonDuplicates) {
        StringBuilder concatString = new StringBuilder();

        for (Character nonDuplicate : nonDuplicates) {
            concatString.append(nonDuplicate);
        }

        return concatString.toString();
    }

}
