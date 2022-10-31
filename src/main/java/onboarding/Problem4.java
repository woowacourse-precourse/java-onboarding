package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); ++i) {
            if (isAlpha(word.charAt(i))) {
                answer += ConvRascalChar(word.charAt(i));
            }
            else {
                answer += word.charAt(i);
            }
        }
        return answer;
    }

    private static boolean isAlpha(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    private static char toUpper(char c) {
        char ret = c;
        if (c >= 'a' && c <= 'z') {
            ret -= 'a' - 'A';
        }
        return ret;
    }

    private static char ConvRascalChar(char c) {
        char upperChar = toUpper(c);
        int index = upperChar - 'A' + 1;

        if (index <= 13) {
            return c += ((13 - index) * 2) + 1;
        }
        return c -= ((index - 14) * 2) + 1;
    }
}
