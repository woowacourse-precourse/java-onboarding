package onboarding;

public class Problem4 {

    private static final int WORD_MIN_LENGTH = 1;
    private static final int WORD_MAX_LENGTH = 1000;
    private static final char LOWERCASE_A = 'a';
    private static final char LOWERCASE_Z = 'z';
    private static final char UPPERCASE_A = 'A';
    private static final char UPPERCASE_Z = 'Z';
    private static final char[] REVERSE_LOWERCASE_ALPABET = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's',
        'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
    private static final char[] REVERSE_UPPERCASE_ALPABET = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S',
        'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

    public static String solution(String word) {
        if (!checkWordLengthValid(word)) {
            throw new IllegalArgumentException("[error] 잘못된 word가 입력되었습니다.");
        }
        String answer = changeWordLetterAlphabetReverse(word);
        return answer;
    }

    public static boolean checkWordLengthValid(String word) {
        return WORD_MIN_LENGTH <= word.length() && word.length() <= WORD_MAX_LENGTH;
    }

    public static boolean checkLowercaseAlphabet(char letter) {
        return LOWERCASE_A <= letter && letter <= LOWERCASE_Z;
    }

    public static boolean checkUppercaseAlphabet(char letter) {
        return UPPERCASE_A <= letter && letter <= UPPERCASE_Z;
    }

    public static String changeWordLetterAlphabetReverse(String word) {
        String result = "";
        for (char letter : word.toCharArray()) {
            if (checkLowercaseAlphabet(letter)) {
                result += REVERSE_LOWERCASE_ALPABET[letter - LOWERCASE_A];
            } else if (checkUppercaseAlphabet(letter)) {
                result += REVERSE_UPPERCASE_ALPABET[letter - UPPERCASE_A];
            } else if (letter < UPPERCASE_A || (UPPERCASE_Z < letter && letter < LOWERCASE_A)
                || LOWERCASE_Z < letter) {
                result += letter;
            }
        }
        return result;
    }
}
