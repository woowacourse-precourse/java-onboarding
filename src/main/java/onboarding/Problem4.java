package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        char[] wordToChar = word.toCharArray();

        for (char c: wordToChar) {
            if (isAlphabet(c)) {
                c = converter(c);
            }
            sb.append(c);
        }

        return String.valueOf(sb);
    }

    private static char converter(char alphabet) {
        if (isUpper(alphabet)) {
            return (char)('Z' - (alphabet - 'A'));
        } else if (isLower(alphabet)) {
            return (char)('z' - (alphabet - 'a'));
        } else {
            return alphabet;
        }
    }

    private static boolean isAlphabet(char alphabet) {
        return isUpper(alphabet) || isLower(alphabet);
    }

    private static boolean isUpper(char alphabet) {
        return alphabet >= 'A' && alphabet <= 'Z';
    }

    private static boolean isLower(char alphabet) {
        return alphabet >= 'a' && alphabet <= 'z';
    }
}
