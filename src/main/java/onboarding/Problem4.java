package onboarding;

public class Problem4 {
    private static char convertAscii(char c) {
        if ('a' <= c && 'z' >= c) {
            c = (char)('z' - (c - 'a'));
        } else if ('A' <= c && 'Z' >= c) {
            c = (char)('Z' - (c - 'A'));
        }
        return c;
    }
    public static String solution(String word) {
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            wordArr[i] = convertAscii(wordArr[i]);
        }
        word = String.valueOf(wordArr);
        return word;
    }
}
