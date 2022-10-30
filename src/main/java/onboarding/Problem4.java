package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char getMatchingCharacter(char input) {
        boolean isUpperCase = true;
        if ('a' <= input) isUpperCase = false;
        char standard = isUpperCase ? 'A' : 'a';

        int index = input - standard;
        return (char) (standard + 25 - index);
    }
}
