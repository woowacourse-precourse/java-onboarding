package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char convert(char input) {
        if (!Character.isAlphabetic(input)) {
            return input;
        }

        if (Character.isLowerCase(input)) {
            return (char)('a' + 'z' - input);
        }

        return (char)('A' + 'Z' - input);
    }
}
