package onboarding;

public class Problem4 {
    private static int checkWord(String word) {
        if ((word.length() < 1) || (word.length() > 1000)) {
            return 0;
        }
        for (char c : word.toCharArray()) {
            if (c == ' ') continue;
            if (!Character.isAlphabetic(c)) return -1;
        }
        return 1;
    }
    private static char convertAscii(char c) {
        if ('a' <= c && 'z' >= c) {
            c = (char)('z' - (c - 'a'));
        } else if ('A' <= c && 'Z' >= c) {
            c = (char)('Z' - (c - 'A'));
        }
        return c;
    }
    public static String solution(String word) {
        if (checkWord(word) == 0) {
            return "StringLengthError";
        } else if (checkWord(word) == -1) {
            return "isNotAlphaError";
        }

        char[] wordArr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            wordArr[i] = convertAscii(wordArr[i]);
        }
        word = String.valueOf(wordArr);
        return word;
    }
}
