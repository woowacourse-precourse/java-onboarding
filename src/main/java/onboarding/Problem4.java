package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean checkAlpha(char letter) {
        return Character.isAlphabetic(letter) ;
    }

    public static int changeCharacter(char letter) {
        if (Character.isUpperCase(letter)) {
            return 25 - letter + 'A' * 2;
        }
        return 25 - letter + 'a' * 2;
    }
}
