package onboarding.problem4;

public class TreeFrogDictionary {
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
