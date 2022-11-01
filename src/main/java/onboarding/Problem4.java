package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return getOppositeWord(word);
    }

    private static String getOppositeWord(String word) {
        StringBuilder oppositeWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            oppositeWord.append(translateCharacter(word.charAt(i)));
        }
        return oppositeWord.toString();
    }

    private static char translateCharacter(char ch) {
        if (Character.isLowerCase(ch)) {
            return (char) ('z' - (ch - 'a'));
        }
        if (Character.isUpperCase(ch)) {
            return (char) ('Z' - (ch - 'A'));
        }
        return ch;
    }
}
