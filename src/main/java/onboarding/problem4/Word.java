package onboarding.problem4;

public class Word {
    static final char A_LOWERCASE = 'a';
    static final char A_UPPERCASE = 'A';
    static final char Z_LOWERCASE = 'z';
    static final char Z_UPPERCASE = 'Z';

    public static char changeAlphabet(char alphabet) {
        if (!Character.isAlphabetic(alphabet)) {
            return alphabet;
        }
        if (isCapitalAlphabet(alphabet)) {
            return capAlphabetReverse(alphabet);
        }
        return smlAlphabetReverse(alphabet);
    }

    public static boolean isCapitalAlphabet(char character) {
        if (A_UPPERCASE <= character && character <= Z_UPPERCASE) {
            return true;
        }
        return false;
    }

    public static char capAlphabetReverse(char alphabet) {
        return (char)(Z_UPPERCASE - alphabet + A_UPPERCASE);
    }

    public static char smlAlphabetReverse(char alphabet) {
        return (char)(Z_LOWERCASE - alphabet + A_LOWERCASE);
    }

    public static String changeWord(String word) {
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            char reverseChar = changeAlphabet(word.charAt(i));
            newWord += reverseChar;
        }
        return newWord;
    }
}
