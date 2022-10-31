package onboarding.problem4;

public class Alphabet {
    static final char A_LOWERCASE = 'a';
    static final char A_UPPERCASE = 'A';
    static final char Z_LOWERCASE = 'z';
    static final char Z_UPPERCASE = 'Z';

    public static char changeAlphabet(char character) {
        if (!Character.isAlphabetic(character)) {
            return character;
        }
        return alphabetReverse(character);
    }

    public static boolean isCapitalAlphabet(char character) {
        if (A_UPPERCASE <= character && character <= Z_UPPERCASE) {
            return true;
        }
        return false;
    }

    public static char alphabetReverse(char alphabet) {
        if (isCapitalAlphabet(alphabet)){
            return (char) (Z_UPPERCASE - alphabet + A_UPPERCASE);
        }
        return (char)(Z_LOWERCASE - alphabet + A_LOWERCASE);
    }

}
