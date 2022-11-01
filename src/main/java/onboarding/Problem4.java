package onboarding;

public class Problem4 {
    public static String solution(String word) {
        assert (word != null);

        int wordLength = word.length();
        char[] wordWithReplacedLetters = new char[word.length()];
        char c;

        for (int i = 0; i < wordLength; i++) {
            c = word.charAt(i);

            if (isEnglishAlphabetUpperCase(c)) {
                c = (char) ('Z' - (c % 'A'));
            } else if (isEnglishAlphabetLowerCase(c)) {
                c = (char) ('z' - (c % 'a'));
            }

            wordWithReplacedLetters[i] = c;
        }

        return new String(wordWithReplacedLetters);
    }

    private static boolean isEnglishAlphabetUpperCase(int codePoint) {
        return codePoint >= 'A' && codePoint <= 'Z';
    }

    private static boolean isEnglishAlphabetLowerCase(int codePoint) {
        return codePoint >= 'a' && codePoint <= 'z';
    }
}
