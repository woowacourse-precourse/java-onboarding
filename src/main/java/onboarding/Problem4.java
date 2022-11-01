package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sentence = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++) {
            sentence.setCharAt(i, changeAlphabet(word.charAt(i)));
        }
        return sentence.toString();
    }

    private static char changeAlphabet(char character) {
        if ('a' <= character && character <= 'z')
            return (char) (219 - character);
        if ('A' <= character && character <= 'Z')
            return (char) (155 - character);
        return character;
    }
}
