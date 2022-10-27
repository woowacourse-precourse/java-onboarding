package onboarding;

public class Problem4 {

    public static final Character UPPER_FIRST_CHARACTER = 'A';
    public static final Character UPPER_LAST_CHARACTER = 'Z';

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean checkAlpha(Character target) {
        return Character.isAlphabetic(target);
    }

    public static boolean checkUppder(Character target) {
        return Character.isLowerCase(target);
    }

    public static Character changeCharUpperCase(Character target) {
        int diff = target - UPPER_FIRST_CHARACTER;
        return (char)(UPPER_LAST_CHARACTER - diff);
    }
}
