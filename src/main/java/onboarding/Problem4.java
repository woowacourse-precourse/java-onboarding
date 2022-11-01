package onboarding;

public class Problem4 {
    private static boolean isUppercase(char c) {
        if (c >= 'A' && c <= 'Z')
            return true;
        return false;
    }

    private static boolean isLowercase(char c) {
        if (c >= 'a' && c <= 'z')
            return true;
        return false;
    }

    public static String solution(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isUppercase(c)) {
                result += (char)('Z' - c + 'A');
            }
            else if (isLowercase(c)) {
                result += (char)('z' - c + 'a');
            }
            else {
                result += c;
            }
        }
        return result;
    }
}
