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

    public static String replaceSmallAlphabetReverse(String word, int alphabetLocation) {
        String smallAlphabetLine = "abcdefghijklmnopqrstuvwxyz";
        int i = 0;

        i = smallAlphabetLine.indexOf(word.charAt(alphabetLocation)) + 1;

        word = word.substring(0, alphabetLocation)
                + smallAlphabetLine.charAt(smallAlphabetLine.length() - i)
                + word.substring(alphabetLocation + 1);

        return word;
    }

    public static String replaceBigAlphabetReverse(String word, int alphabetLocation) {
        String bigAlphabetLine = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int i = 0;

        i = bigAlphabetLine.indexOf(word.charAt(alphabetLocation)) + 1;

        word = word.substring(0, alphabetLocation)
                + bigAlphabetLine.charAt(bigAlphabetLine.length() - i)
                + word.substring(alphabetLocation + 1);

        return word;
    }
}
