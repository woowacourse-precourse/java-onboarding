package onboarding;

public class Problem4 {

    private static char[] upperReverse;
    private static char[] lowerReverse;

    static {
        upperReverse = new char[26];
        char upperLetter = 'Z';
        for (int i = 0; i < 26; i++) {
            upperReverse[i] = upperLetter;
            upperLetter--;
        }

        lowerReverse = new char[26];
        char lowerLetter = 'z';
        for (int i = 0; i < 26; i++) {
            lowerReverse[i] = lowerLetter;
            lowerLetter--;
        }
    }
    public static String solution(String word) {

        StringBuilder result = new StringBuilder();

        char[] wordToChars = word.toCharArray();

        for (char wordToChar : wordToChars) {
            if ('A' <= wordToChar && wordToChar <= 'Z') {
                char reverse = upperReverse[((int) wordToChar - 'A')];
                result.append(reverse);
                continue;
            }

            if ('a' <= wordToChar && wordToChar <= 'z') {
                char reverse = lowerReverse[((int) wordToChar - 'a')];
                result.append(reverse);
                continue;
            }

            result.append(wordToChar);
        }

        return result.toString();
    }
}
