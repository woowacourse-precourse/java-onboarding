package onboarding;

public class Problem4 {
    private static char convertUpper(char letter) {
        int difference = letter - 65;
        int converted = 90 - difference;

        return (char) converted;

    }

    private static char convertLower(char letter) {
        int difference = letter - 97;
        int converted = 122 - difference;

        return (char) converted;
    }

    public static String solution(String word) {
        String answer = "";

        return answer;
    }
}
