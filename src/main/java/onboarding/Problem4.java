package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return replaceAlphabet(word);
    }

    public static String replaceAlphabet(String word) {
        for (int i = 0; i < word.length(); i++) {
            if ((word.charAt(i) >= 97) && (word.charAt(i) <= 122)) {
                word = replaceSmallAlphabetReverse(word, i);
            }
            if ((word.charAt(i) >= 65) && (word.charAt(i) <= 90)) {
                word = replaceBigAlphabetReverse(word, i);
            }
        }

        return word;
    }

    private static String replaceSmallAlphabetReverse(String word, int i) {
        return "";
    }


    private static String replaceBigAlphabetReverse(String word, int i) {
        return "";
    }
}
