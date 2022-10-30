package onboarding.problem4;

public class Word {
    static final char A_LOWERCASE = 'a';
    static final char A_UPPERCASE = 'A';
    static final char Z_LOWERCASE = 'z';
    static final char Z_UPPERCASE = 'Z';

    public static char changeAlphabet(char character) {
        if ((character < A_LOWERCASE || character > Z_LOWERCASE) &&
                (character < A_UPPERCASE || character > Z_UPPERCASE)) {
            return character;
        }
        if (character < Z_UPPERCASE) {
            return (char)(Z_UPPERCASE - character + A_UPPERCASE);
        }
        return (char)(Z_LOWERCASE - character + A_LOWERCASE);
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
