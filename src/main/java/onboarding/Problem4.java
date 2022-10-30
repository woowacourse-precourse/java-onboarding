package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (Character character: word.toCharArray()) {
            answer.append(convertWord(character));
        }

        return answer.toString();
    }

    private static Character convertWord(char character) {
        if (!Character.isAlphabetic(character)) {
            return character;
        }

        if (Character.isUpperCase(character)) {
            return (char) (90 - (((int)character) - 65));
        }

        if (Character.isLowerCase(character)) {
            return (char) (122 - (((int)character) - 97));
        }

        return character;
    }
}
