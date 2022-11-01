package onboarding;


import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!cryptogram.matches("^[a-z]*$")) {
            return "false";
        }
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return "false";
        }

        return getDecrypto(cryptogram);
    }

    private static String getDecrypto(String cryptogram) {
        Stack<Character> cryptor = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char crypto : cryptogram.toCharArray()) {
            if (!cryptor.isEmpty() && cryptor.peek() == crypto) {
                cryptor.pop();
                continue;
            }

            cryptor.push(crypto);
        }

        cryptor.forEach(result::append);

        return result.toString();
    }
}
