package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static boolean isAlphabet(char letter) {
        return Character.isUpperCase(letter) || Character.isLowerCase(letter);
    }

    private static char convertLetterToReverse(char letter) {
        if (Character.isUpperCase(letter)) {
            return (char) (155 - letter);
        } else {
            return (char) (219 - letter);
        }
    }
}
