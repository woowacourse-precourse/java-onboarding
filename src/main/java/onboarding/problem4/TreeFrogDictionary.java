package onboarding.problem4;

public class TreeFrogDictionary {
    public static String convertTreeFrogWord(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(convertCharToTreeFrogChar(word.charAt(i)));
        }
        return sb.toString();
    }

    private static char convertCharToTreeFrogChar(char character) {
        if (Character.isUpperCase(character)) {
            return (char) ('Z' - character + 'A');
        } else if (Character.isLowerCase(character)) {
            return (char) ('z' - character + 'a');
        } else {
            return character;
        }
    }
}
