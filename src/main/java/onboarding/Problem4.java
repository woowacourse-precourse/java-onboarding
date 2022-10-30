package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char getMatchingCharacter(char input) {
        if (!Character.isLetter(input)) return input;

        boolean isUpperCase = 'a' > input;
        char standard = isUpperCase ? 'A' : 'a';

        int index = input - standard;
        return (char) (standard + 25 - index);
    }
}
