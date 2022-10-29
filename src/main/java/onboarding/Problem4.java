package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (char character : word.toCharArray()) {
            sb.append(convert(character));
        }
        return sb.toString();
    }

    private static char convert(char character) {
        if (!Character.isAlphabetic(character)) {
            return character;
        }

        if (Character.isLowerCase(character)) {
            return (char)('a' + 'z' - character);
        }

        return (char)('A' + 'Z' - character);
    }
}
