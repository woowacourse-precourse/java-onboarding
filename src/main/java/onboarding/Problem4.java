package onboarding;

public class Problem4 {
    public static String solution(String word) {
        validate(word);
        return convertMessage(word);
    }

    private static void validate(String word) {
        int length = word.length();
        if (length < 1 || length > 1000) {
            throw new IllegalArgumentException("word는 길이가 1 이상 1,000 이하인 문자열이어야 합니다.");
        }
    }

    private static String convertMessage(String word) {
        StringBuilder convertedMessage = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            convertedMessage.append(convertCharacter(word.charAt(i)));
        }
        return convertedMessage.toString();
    }

    private static char convertCharacter(char character) {
        if (Character.isLowerCase(character)) {
            character = (char) ('z' - (character - 'a'));
        }
        if (Character.isUpperCase(character)) {
            character = (char) ('Z' - (character - 'A'));
        }
        return character;
    }
}
