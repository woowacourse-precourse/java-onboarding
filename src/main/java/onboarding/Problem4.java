package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sb.append(reverseEnAlphabet(c));
        }
        return sb.toString();
    }

    private static boolean isEnAlphabetic(char c) {
        if (c < 'A' || c > 'z') {
            return false;
        }
        return true;
    }

    private static char reverseEnAlphabet(char c) {
       if (!isEnAlphabetic(c)) {
           return c;
       }

       if (Character.isLowerCase(c)) {
           return (char)('a'+'z' - c);
       }
       return (char)('A'+'Z' - c);
    }
}
