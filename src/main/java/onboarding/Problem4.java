package onboarding;


public class Problem4 {
    public static String solution(String word) {
        final StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            final char ch = word.charAt(i);
            answer.append(reverseCharacter(ch));
        }

        return answer.toString();
    }

    private static char reverseCharacter(char character) {
        if (!Character.isAlphabetic(character)) {
            return character;
        }

        if (Character.isUpperCase(character)) {
            return (char) ('A' + 'Z' - character);
        } else {
            return (char) ('a' + 'z' - character);
        }
    }

}
