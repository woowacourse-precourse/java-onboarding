package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int idx = 0; idx < word.length(); idx++) {
            stringBuilder.append(convertCharacter(word.charAt(idx)));
        }

        return stringBuilder.toString();
    }

    private static char convertCharacter(char character) {
        if (Character.isLowerCase(character)) {
            return (char) ('a' + 'z' - character);
        } else if (Character.isUpperCase(character)) {
            return (char) ('A' + 'Z' - character);
        } else {
            return character;
        }
    }
}
